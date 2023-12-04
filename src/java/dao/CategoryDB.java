package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import entity.Category;
import java.util.List;



public class CategoryDB {

    public static void insert(Category category) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(category);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public static void update(Category category) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(category);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
      public List<Category> findALL() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT c FROM Category c " ;
                        
        TypedQuery<Category> q = em.createQuery(qString, Category.class);
        return  q.getResultList();
    }
    public static Category findCategoryById(int categoryID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qString = "SELECT c FROM Category c " +
                        "WHERE c.categoryID = :categoryID";
        
        TypedQuery<Category> q = em.createQuery(qString, Category.class);
        
        q.setParameter("categoryID", categoryID);
        
        Category result = null;
        
        try {
            result = q.getSingleResult();
            
        } catch (NoResultException ex) {
            return null;
            
        } finally {
            em.close();
            
        }   
        return (Category)result;
    }
    public static void delete(Category category) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(category));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }
    public static void main(String[] args){ 
//        Category c = new Category();
//        c.setCategoryID(1);
//        c.setCategoryName("latte");
//        CategoryDB.insert(c);
      
    }
  }