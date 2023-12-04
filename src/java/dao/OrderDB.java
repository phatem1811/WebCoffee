package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.NamedQuery;
import entity.Order;
import entity.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;


public class OrderDB {

    public static void insert(Order order) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(order);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Order order) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(order);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Order order) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(order));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }
     public List<Order> findALL() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT c FROM Order c " ;
                        
        TypedQuery<Order> q = em.createQuery(qString, Order.class);
        return  q.getResultList();
    }
    public static List<Order> findOrderByUserId(int userId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qString = "SELECT o FROM Order o " +
                        "WHERE o.user.userId = :userId";
        
        TypedQuery<Order> q = em.createQuery(qString, Order.class);
        
        q.setParameter("userId", userId);
        return  q.getResultList();

    }
    public static Order findOrderById(int orderId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qString = "SELECT o FROM Order o " +
                        "WHERE o.orderId = :orderId";
        
        TypedQuery<Order> q = em.createQuery(qString, Order.class);
        
        q.setParameter("orderId", orderId);
        
        Order result = null;
        
        try {
            result = q.getSingleResult();
            
        } catch (NoResultException ex) {
            return null;
            
        } finally {
            em.close();
            
        }
        
        return (Order)result;
    }
    public static void main(String[] args){
       
        
    }
}