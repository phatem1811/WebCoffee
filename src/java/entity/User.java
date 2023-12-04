package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author 84971  IDENTITY
 */

@Entity
@Table(name="user")  

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String username;
    private String password;
    private String name;
    private String email;
    private String sdt;
    private String diachi;
     private int role = 0 ;

   
     
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
   

    public User() {
        
    }

    public User(int userId, String username, String password, String name, String email, String sdt, String diachi) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.sdt = sdt;
        this.diachi = diachi;
    }
    
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }    
     public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}