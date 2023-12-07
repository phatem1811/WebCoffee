package entity;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable {

    private List<Item> items;

    public Cart() {
        items = new ArrayList();
    }
//    }
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getCount() {
        return items.size();
    }
//  
    public int getQuantitybyID(int id){
        return getItembyID(id).getQuantity();
    }
    public Item getItembyID(int id) {
        for(Item i: items){
            if(i.getProduct().getProductID()==id)
                return i;
        }
        return null;
    }
    public void addItem(Item item) {
        if(getItembyID(item.getProduct().getProductID()) != null){
            Item i = getItembyID(item.getProduct().getProductID());
            i.setQuantity(i.getQuantity() + item.getQuantity());
            
        }
        else  items.add(item);
   }
    
    public void removeItem(int id) {
        if(getItembyID(id) != null) {
           Item i = getItembyID(id);
          items.remove(i);
        }
    }

    public double getTotalPrice (){
        double t =0;
        for(Item i: items) 
            t+= i.getTotal();
        return t;
    }
      public String getTotalPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotalPrice());
    }
    

    
}