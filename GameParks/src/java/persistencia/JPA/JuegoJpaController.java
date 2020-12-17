package persistencia.JPA;

import logica.Juego;
import persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class JuegoJpaController implements Serializable {

    public JuegoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public JuegoJpaController() {
        emf = Persistence.createEntityManagerFactory("GameParksPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean create(Juego juego) {
        EntityManager em = null;
        boolean res = false;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(juego);
            em.getTransaction().commit();
            res = true;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return res;
    }

    public boolean edit(Juego juego) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        boolean res = false;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            juego = em.merge(juego);
            em.getTransaction().commit();
            res = true;
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = juego.getJuego_id();
                if (findJuego(id) == null) {
                    throw new NonexistentEntityException("The juego with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return res;
    }

    public boolean destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        boolean res = false;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Juego juego;
            try {
                juego = em.getReference(Juego.class, id);
                juego.getJuego_id();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The juego with id " + id + " no longer exists.", enfe);
            }
            em.remove(juego);
            em.getTransaction().commit();
            res = true;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return res;
    }

    public List<Juego> findJuegoEntities() {
        return findJuegoEntities(true, -1, -1);
    }

    public List<Juego> findJuegoEntities(int maxResults, int firstResult) {
        return findJuegoEntities(false, maxResults, firstResult);
    }

    private List<Juego> findJuegoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Juego.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Juego findJuego(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Juego.class, id);
        } finally {
            em.close();
        }
    }

    public int getJuegoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Juego> rt = cq.from(Juego.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
