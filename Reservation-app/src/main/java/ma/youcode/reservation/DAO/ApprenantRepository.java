package ma.youcode.reservation.DAO;

import ma.youcode.reservation.Models.ApprenantEntity;
import ma.youcode.reservation.Models.ReservationEntity;
import ma.youcode.reservation.Models.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprenantRepository extends JpaRepository<ApprenantEntity, Long> {
    //Apprenant Non accepter
  //  @Query("SELECT * FROM ApprenantEntity a left join UsersEntity u On a.iduser= u.iduser ")
    List<ApprenantEntity> getUsersEntityByStatusFalse();

//    =========================


//    ========================

    //Apprenants Accepter
    @Query("SELECT a FROM ApprenantEntity a WHERE a.status = true")
    List<ApprenantEntity> getUsersEntityByStatusTrue();

    //Search


}
