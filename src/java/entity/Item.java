package entity;

import java.io.Serializable;
import java.text.NumberFormat;

public class Item implements Serializable {

    private Product product;
    private int quantity;



    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void setProduct(Product p) {
        product = p;
    }

    public Product getProduct() {
        return product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        double total = product.getProductPrice()* quantity;
        return total;
    }

    public String getTotalCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}