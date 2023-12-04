/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Orderdetail;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

/**
 *
 * @author 84971
 */
public class OrderdetailDB {
     public static void insert(Orderdetail orderdetail) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(orderdetail);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Orderdetail orderdetail) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(orderdetail);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Orderdetail orderdetail) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(orderdetail));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }
    public static List<Orderdetail> findOrderdetailByOrderId(int orderId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qString = "SELECT o FROM Orderdetail o " +
                        "WHERE o.order.orderId = :orderId";
        
        TypedQuery<Orderdetail> q = em.createQuery(qString, Orderdetail.class);
        
        q.setParameter("orderId", orderId);
        return  q.getResultList();

    }
}
