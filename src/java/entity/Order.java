/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "order_table")
public class Order implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int orderId;
    private String sdt;
    private String adress;
   
    private String date;
    private double total;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<Orderdetail> Orderdetails;
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

  

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
 
     
      public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public List<Orderdetail> getOrderdetails() {
        return Orderdetails;
    }

    public void setOrderdetails(List<Orderdetail> Orderdetails) {
        this.Orderdetails = Orderdetails;
    }
    
    
}
