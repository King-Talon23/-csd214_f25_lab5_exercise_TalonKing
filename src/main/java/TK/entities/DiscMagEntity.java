package TK.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class DiscMagEntity extends MagazineEntity {

    @Column(nullable = true)
    private boolean hasDisc = false;

    public DiscMagEntity() {}

    public DiscMagEntity(boolean hasDisc, int orderQty, Date currentIssue, String title, double price, int copies) {
        super(orderQty, currentIssue, title, price, copies);
        this.hasDisc = hasDisc;
    }

    public boolean isHasDisc() { return hasDisc; }
    public void setHasDisc(boolean hasDisc) { this.hasDisc = hasDisc; }
}

