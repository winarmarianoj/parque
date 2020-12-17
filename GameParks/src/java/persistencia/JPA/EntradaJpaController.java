package persistencia.JPA;

import logica.Entrada;
import persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TemporalType;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class EntradaJpaController implements Serializable {

    public EntradaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntradaJpaController() {
        emf = Persistence.createEntityManagerFactory("GameParksPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean create(Entrada entrada) {
        EntityManager em = null;
        boolean res = false;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entrada);
            em.getTransaction().commit();
            res = true;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return res;
    }

    public boolean edit(Entrada entrada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        boolean res = false;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            entrada = em.merge(entrada);
            em.getTransaction().commit();
            res = true;
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = entrada.getEntrada_id();
                if (findEntrada(id) == null) {
                    throw new NonexistentEntityException("The entrada with id " + id + " no longer exists.");
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
            Entrada entrada;
            try {
                entrada = em.getReference(Entrada.class, id);
                entrada.getEntrada_id();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The entrada with id " + id + " no longer exists.", enfe);
            }
            em.remove(entrada);
            em.getTransaction().commit();
            res = true;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return res;
    }

    public List<Entrada> findEntradaEntities() {
        return findEntradaEntities(true, -1, -1);
    }

    public List<Entrada> findEntradaEntities(int maxResults, int firstResult) {
        return findEntradaEntities(false, maxResults, firstResult);
    }

    private List<Entrada> findEntradaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Entrada.class));
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

    public Entrada findEntrada(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Entrada.class, id);
        } finally {
            em.close();
        }
    }

    public int getEntradaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Entrada> rt = cq.from(Entrada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
