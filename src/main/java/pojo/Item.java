package pojo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GenericGenerator(strategy = "uuid",name="uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String itemName;
    private int itemNumber;

    @ManyToOne
    @JoinColumn(name="b_id")
    private Base base;

    public Item(){

    }

    public Item(String itemName, int itemNumber) {
        this.itemName = itemName;
        this.itemNumber = itemNumber;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemNumber=" + itemNumber +
                ", base=" + base +
                '}';
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }
}
