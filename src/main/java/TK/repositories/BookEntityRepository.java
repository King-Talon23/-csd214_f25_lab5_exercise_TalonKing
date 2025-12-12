package TK.repositories;

import TK.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface BookEntityRepository extends JpaRepository<BookEntity, Long> {

    List<BookEntity> findByAuthor(String author);
}
