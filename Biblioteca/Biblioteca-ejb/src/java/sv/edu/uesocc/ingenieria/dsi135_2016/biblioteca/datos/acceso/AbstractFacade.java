package sv.edu.uesocc.ingenieria.dsi135_2016.biblioteca.datos.acceso;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Ale
 */
public abstract class AbstractFacade<T> {
    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    /**
     * @param entity Entidad a persistir en la base de datos
     * @return TRUE Entidad fue persistida, FALSE en caso de error o no haber insertado la entidad
     * @since hoy
     */
    public boolean crear(T entity) {
        T entidad = create(entity);
        return entidad != null;
    }
    public T create(T entity){
        try {
            EntityManager em = getEntityManager();
            if (entity != null && em != null) {
                em.persist(entity);
                return entity;
            }else{
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error al persistir al entidad\t"+e.getMessage());
            return null;
        }
    }

    /**
     * @param entity Entidad a modificar en la base de datos
     * @return TRUE Entidad fue modificada, FALSE en caso de error o no haber modificada la entidad
     * @since hoy
     */
    public boolean editar(T entity) {

        T entidad = edit(entity);
        return entidad != null;
    }
    public T edit(T entity){
        try {
            EntityManager em = getEntityManager();
            if (entity != null && em != null) {
                em.merge(entity);
                return entity;
            }else{
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error al editar \t"+e.getMessage());
            return null;
        }
    }
    /**
     * @param entity Entidad a eliminar en la base de datos
     * @return TRUE Entidad fue eliminada de la base de datos, FALSE en caso de error o no haber eliminada la entidad
     * @since hoy
     */
    public boolean eliminar(T entity) {
        T entidad = remove(entity);
        return entidad != null;
    }
    public T remove(T entity){
        try {
            EntityManager em = getEntityManager();
            if (entity != null && em != null) {
                em.remove(em.merge(entity));
                return entity;
            }else{
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar la entidad T\t"+e.getMessage());
            return null;
        }
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Number) q.getSingleResult()).intValue();
    }
    
}
