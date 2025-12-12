package TK.repositories;

import TK.entities.DiscMagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscMagEntityRepository extends JpaRepository<DiscMagEntity, Long> {
}
