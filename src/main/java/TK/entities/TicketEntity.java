package TK.entities;

import jakarta.persistence.*;

@Entity
public class TicketEntity extends ProductEntity {

    @Column(nullable = false)
    private String description;

    public TicketEntity() {}

    public TicketEntity(String description, double price, String title, int copies) {
        this.description = description;
        this.price = price;
        this.title = title;
        this.copies = copies;
    }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}