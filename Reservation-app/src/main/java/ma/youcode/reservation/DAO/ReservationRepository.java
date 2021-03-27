package ma.youcode.reservation.DAO;

import ma.youcode.reservation.Models.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

   // @Query("SELECT r FROM ReservationEntity r WHERE r.status = false")
  // @Query("SELECT r.idreservation,r.status,r.currentdate,u.iduser,u.nom,u.prenom FROM ReservationEntity r,UsersEntity u WHERE r.iduser=u.iduser and r.status = false")
    @Query("SELECT r FROM ReservationEntity r WHERE r.status = FALSE ")
    List<ReservationEntity> getReservationEntityByStatus();

    //Update
    @Transactional
    @Modifying
    @Query("update ReservationEntity r set r.status = true where r.idreservation = :id")
    void updateReservationSetStatus(@Param("id") Long id);
}
