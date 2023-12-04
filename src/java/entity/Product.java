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
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)  
    private int productID;
    private String productName;
    
    private String img;
    private int productPrice;
    private int productSize;
    
    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<Orderdetail> Orderdetails;
    public Product() {}

    
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }




    public int getProductID() {
        return productID;
    }

    public int setProductID(int productID) {
     
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    
    public int getProductSize() {
        return productSize;
    }

    public void setProductSize(int productSize) {
        this.productSize = productSize;
    }

}