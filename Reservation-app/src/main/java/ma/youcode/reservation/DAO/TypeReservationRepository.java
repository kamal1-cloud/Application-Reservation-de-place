package ma.youcode.reservation.DAO;

import ma.youcode.reservation.Models.TypereservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeReservationRepository extends JpaRepository<TypereservationEntity, Integer> {
}
