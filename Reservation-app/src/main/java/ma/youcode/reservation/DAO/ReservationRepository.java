package ma.youcode.reservation.DAO;

import ma.youcode.reservation.Models.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
//    @Query("SELECT r FROM ReservationEntity r WHERE r.status = FALSE ")
//    ReservationEntity findByStatus (Boolean Status);

//    @Modifying
//    @Query("update ReservationEntity r set r.status = :status")
//    Boolean updateUserSetStatusForName(@Param("status") Boolean status);
    @Query("SELECT r FROM ReservationEntity r WHERE r.status = false")
    List<ReservationEntity> getReservationEntityByStatus();
    //Update

    @Modifying(clearAutomatically = true)
    @Query("update ReservationEntity r set r.status = true where r.idreservation = :id")
    void updateReservationSetStatus(@Param("id") Long id);
}
