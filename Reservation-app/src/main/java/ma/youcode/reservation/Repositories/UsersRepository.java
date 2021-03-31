package ma.youcode.reservation.Repositories;

import ma.youcode.reservation.Models.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    @Query("SELECT u FROM UsersEntity u WHERE u.email = :email")
    public UsersEntity getUserByEmail(@Param("email") String email);
//    ================  Search

    @Query("SELECT u FROM UsersEntity u WHERE CONCAT(u.nom, ' ', u.prenom, ' ', u.cin, ' ', u.email) LIKE %?1%")
    public List<UsersEntity> search(String keyword);


//===================
//Apprenant Non accepter
@Query("SELECT a FROM UsersEntity a where a.status = false")
List<UsersEntity> getUsersEntityByStatusFalse();


    //Apprenants Accepter
    @Query("SELECT a FROM UsersEntity a WHERE a.status = true")
    List<UsersEntity> getUsersEntityByStatusTrue();
    //    =========================
    //Update (Activer le compte)
    @Transactional
    @Modifying
    @Query("update UsersEntity a set a.status = true where a.iduser = :id")
    void updateApprenantSetStatusToTrue(@Param("id") Long id);

    //Update (Désactiver le compte)
    @Transactional
    @Modifying
    @Query("update ApprenantEntity a set a.status = false where a.iduser = :id")
    void updateApprenantSetStatusToFalse(@Param("id") Long id);


}
