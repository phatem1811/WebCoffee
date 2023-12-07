/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.DBUtil;
import entity.Product;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import entity.Category;

import entity.Product;
import entity.User;
import java.util.List;
import javax.persistence.Query;

public class ProductDB {

    public static void insert(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            //trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(product);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(Product product) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(product));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }
      
          public static Product findProductrById(int productID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qString = "SELECT p FROM Product p " +
                        "WHERE p.productID = :productID";
        
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        
        q.setParameter("productID", productID);
        
        Product result = null;
        
        try {
            result = q.getSingleResult();
            
        } catch (NoResultException ex) {
            return null;
            
        } finally {
            em.close();
            
        }
        
        return (Product)result;
    }
        
    public static List<Product> searchByName(String productName) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Product p WHERE p.productName LIKE :productName";
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        q.setParameter("productName", "%" + productName + "%");
        try {
            List<Product> products = q.getResultList();
            return products;
        } finally {
            em.close();
        }
    }

    public List<Product> findALL() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT p FROM Product p " ;
                        
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        return  q.getResultList();
    }
     public static List<Product> findProductByCategoryId(int categoryID) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qString = "SELECT p FROM Product p " +
                        "WHERE p.category.categoryID = :categoryID";
        
        TypedQuery<Product> q = em.createQuery(qString, Product.class);
        
        q.setParameter("categoryID", categoryID);
        return  q.getResultList();

    } 
     public static int getTotalProducts() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        int count = 0;
        String qString = "SELECT COUNT(a) FROM Product a";
        try {
            Query query = em.createQuery(qString);
            count = ((Number) query.getSingleResult()).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    public static List<Product> getProductByPage(int page, int pageSize) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<Product> list = null;
        try {
            String qString = "SELECT a FROM Product a ORDER BY a.productID";
            Query query = em.createQuery(qString);
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);

            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args){
         Category c =new Category();
      
        
        c.setCategoryName("latte");
//        CategoryDB.insert(c);
          Product p = new Product();
        p.setProductName("Latte Machiato size s ");

        p.setImg("http://www.aerolatte.com/wp-content/uploads/2020/02/three-layer-mochiato.jpg");
        p.setProductPrice(100000);
        p.setProductSize(1);
        p.setCategory(c);
        ProductDB.insert(p);
//        System.out.println(p.getCategory().getCategoryName() );
////        
////          
//        Product p = new Product();
//       
//        p.setProductName("Expresso Macchiatos - Size S");
// 
//        p.setImg("https://www.thespruceeats.com/thmb/XUYpKtgCFv8dOkzA0vDIroWu6Bs=/3089x2060/filters:fill(auto,1)/85153452-56a176765f9b58b7d0bf84dd.jpg");
//        p.setProductPrice(49000);
//        p.setProductSize(1);
//        p.setCategory(c);
//        
//        ProductDB p = new ProductDB();
//        List<Product> list= p.findProductById(1);
//         for (Product o : list) {
//         System.out.println(o.getProductName() );
       
       
       
       
       
////     
//            List<Product> list =  p.findProductById(2);
//            for (Product o : list) {
//           System.out.println(o.getCategory().getCategoryID() );     }
////           
//           Product pro = p.findProductById(9);
//             System.out.println(pro.getProductName());     
      
//        ProductDB.insert(p);
//        System.out.println(p.getCategory().getCategoryName() );
           
         }
}
     