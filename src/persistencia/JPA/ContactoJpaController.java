/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.JPA;

import logica.Contacto;
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

/**
 *
 * @author mariano
 */
public class ContactoJpaController implements Serializable {

    public ContactoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public ContactoJpaController() {
        emf = Persistence.createEntityManagerFactory("ParquePU");
    }    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean create(Contacto contacto) {
        EntityManager em = null;
        boolean res = false;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
            res = true;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return res;
    }

    public boolean edit(Contacto contacto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        boolean res = false;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            contacto = em.merge(contacto);
            em.getTransaction().commit();
            res = true;
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = contacto.getCon_id();
                if (findContacto(id) == null) {
                    throw new NonexistentEntityException("The contacto with id " + id + " no longer exists.");
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
            Contacto contacto;
            try {
                contacto = em.getReference(Contacto.class, id);
                contacto.getCon_id();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contacto with id " + id + " no longer exists.", enfe);
            }
            em.remove(contacto);
            em.getTransaction().commit();
            res = true;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return res;
    }

    public List<Contacto> findContactoEntities() {
        return findContactoEntities(true, -1, -1);
    }

    public List<Contacto> findContactoEntities(int maxResults, int firstResult) {
        return findContactoEntities(false, maxResults, firstResult);
    }

    private List<Contacto> findContactoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contacto.class));
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

    public Contacto findContacto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contacto.class, id);
        } finally {
            em.close();
        }
    }

    public int getContactoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contacto> rt = cq.from(Contacto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
