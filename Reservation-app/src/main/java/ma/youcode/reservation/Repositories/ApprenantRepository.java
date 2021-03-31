package ma.youcode.reservation.Repositories;

import ma.youcode.reservation.Models.ApprenantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ApprenantRepository extends JpaRepository<ApprenantEntity, Long> {

    //Apprenant Non accepter
    @Query("SELECT a FROM ApprenantEntity a where a.status = false")
    List<ApprenantEntity> getUsersEntityByStatusFalse();


    //Apprenants Accepter
    @Query("SELECT a FROM ApprenantEntity a WHERE a.status = true")
    List<ApprenantEntity> getUsersEntityByStatusTrue();
    //    =========================
    //Update (Activer le compte)
    @Transactional
    @Modifying
    @Query("update ApprenantEntity a set a.status = true where a.iduser = :id")
    void updateApprenantSetStatusToTrue(@Param("id") Long id);

    //Update (Désactiver le compte)
    @Transactional
    @Modifying
    @Query("update ApprenantEntity a set a.status = false where a.iduser = :id")
    void updateApprenantSetStatusToFalse(@Param("id") Long id);






}
