package TK.entities;

import jakarta.persistence.*;

@Entity
public class BookEntity extends PublicationEntity {

    @Column(nullable = false)
    private String author;

    public BookEntity() {}

    public BookEntity(String author, String title, double price, int copies) {
        this.author = author;
        this.title = title;
        this.price = price;
        this.copies = copies;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

}