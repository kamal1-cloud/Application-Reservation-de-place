package ma.youcode.reservation.DAO;

import ma.youcode.reservation.Models.ApprenantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprenantRepository extends JpaRepository<ApprenantEntity, Long> {
}
