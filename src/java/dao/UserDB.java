package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.NamedQuery;
import entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

public class UserDB {

    public static void insert(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void update(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static void delete(User user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.remove(em.merge(user));
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }       
    }

    
    

    public static User selectUser(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                "WHERE u.email = :email";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        q.setParameter("email", email);
        try {
            User user = q.getSingleResult();
            return user;
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean emailExists(String email) {
        User u = selectUser(email);   
        return u != null;
    }
 
  
    public List<User> findALL() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " ;
        TypedQuery<User> q = em.createQuery(qString, User.class);
        return  q.getResultList();
   }
    
    public static User findUserById(int userId) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qString = "SELECT u FROM User u " +
                        "WHERE u.userId = :userId";
        
        TypedQuery<User> q = em.createQuery(qString, User.class);
        
        q.setParameter("userId", userId);
        
        User result = null;
        
        try {
            result = q.getSingleResult();
            
        } catch (NoResultException ex) {
            return null;
            
        } finally {
            em.close();
            
        }
        
        return (User)result;
    }
        
    public static User findUserByUsername(String username) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        String qString = "SELECT u FROM User u " +
                        "WHERE u.username = :username";
        
        TypedQuery<User> q = em.createQuery(qString, User.class);
        
        q.setParameter("username", username);
        
        User result = null;
        
        try {
            result = q.getSingleResult();
            
        } catch (NoResultException ex) {
            return null;
            
        } finally {
            em.close();
            
        }
        
        return (User)result;
    }
    public static int getTotalUsers() {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        int count = 0;
        String qString = "SELECT COUNT(a) FROM User a";
        try {
            Query query = em.createQuery(qString);
            count = ((Number) query.getSingleResult()).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
    public static List<User> getUserByPage(int page, int pageSize) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        List<User> list = null;
        try {
            String qString = "SELECT a FROM User a ORDER BY a.userId";
            Query query = em.createQuery(qString);
            query.setFirstResult((page - 1) * pageSize);
            query.setMaxResults(pageSize);

            list = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[]args){ 
       
//     
//       List<User> list =  u.findALL();
//       for (User o : list) {
//       System.out.println(o.getName());      }
//     UserDB u =new UserDB();
//    User a = u.findUserByUsername("qqq");
//////       boolean equals = a.getPassword().equals("1234567");
//////        String password = "1234576" ;
//     System.out.println(a.getPassword());
////////        
//////////       
       
          User u= UserDB.findUserByUsername("admin");
          
          u.setPassword("123");
       

          UserDB.update(u);
          System.out.println(u.getPassword());
//       UserDB u =new UserDB();
//       User a = u.findUserById(2);
//       a.setName("Quốc Kha");
//       UserDB.update(a);
//       System.out.println(a.getName());
    }  
}


   