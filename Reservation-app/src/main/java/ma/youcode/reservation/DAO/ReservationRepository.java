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
//    @Query("SELECT r FROM ReservationEntity r WHERE r.status = FALSE ")
//    ReservationEntity findByStatus (Boolean Status);

//    @Modifying
//    @Query("update ReservationEntity r set r.status = :status")
//    Boolean updateUserSetStatusForName(@Param("status") Boolean status);
//@Query("SELECT r.idreservation,r.iduser,r.currentdate,r.status,u.iduser,u.nom,u.prenom FROM ReservationEntity r INNER JOIN UsersEntity u ON r.status = false  and  r.iduser = u.iduser")
//@Query(value = "select r.idreservation,r.status,r.currentdate,r.idtype,u.iduser,u.nom,u.prenom from reservation r INNER JOIN Users u ON r.iduser = u.iduser and r.status = false",nativeQuery = true)
@Query("SELECT r FROM ReservationEntity r WHERE r.status = false")
    List<ReservationEntity> getReservationEntityByStatus();

    //Update
    @Transactional
    @Modifying
    @Query("update ReservationEntity r set r.status = true where r.idreservation = :id")
    void updateReservationSetStatus(@Param("id") Long id);
}
