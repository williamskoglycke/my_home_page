package se.william.mvcexemple.shoppinglist.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name ="item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Min(1)
    @Column(name = "item_price")
    private double itemPrice;

    @NotNull
    @Size(min=2,max = 30)
    @Column(name = "item_name")
    private String itemName;

    public Item() {
    }

    public Item(int id, double itemPrice, String itemName) {
        this.id = id;
        this.itemPrice = itemPrice;
        this.itemName = itemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName.trim();
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemPrice=" + itemPrice +
                ", itemName='" + itemName + '\'' +
                '}';
    }
}
