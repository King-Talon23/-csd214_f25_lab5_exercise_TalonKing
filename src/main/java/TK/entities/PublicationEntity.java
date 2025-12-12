package TK.entities;

import jakarta.persistence.*;

@Entity
public abstract class PublicationEntity extends ProductEntity {

    public PublicationEntity() {
        super();
    }
}
