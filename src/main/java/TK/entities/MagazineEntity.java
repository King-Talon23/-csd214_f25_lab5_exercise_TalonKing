package TK.entities;


import jakarta.persistence.*;
import java.util.Date;

@Entity
public class MagazineEntity extends PublicationEntity {

    @Column(nullable = false)
    private int orderQty;

    @Column(nullable = false)
    private Date currentIssue;

    public MagazineEntity() {}

    public MagazineEntity(int orderQty, Date currentIssue, String title, double price, int copies) {
        this.orderQty = orderQty;
        this.currentIssue = currentIssue;
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    public int getOrderQty() { return orderQty; }
    public void setOrderQty(int orderQty) { this.orderQty = orderQty; }

    public Date getCurrentIssue() { return currentIssue; }
    public void setCurrentIssue(Date currentIssue) { this.currentIssue = currentIssue; }
}

