package ma.youcode.reservation.DAO;

import ma.youcode.reservation.Models.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    @Query("SELECT u FROM UsersEntity u WHERE u.email = :email")
    public UsersEntity getUserByEmail(@Param("email") String email);
//    ================  Search

    @Query("SELECT u FROM UsersEntity u WHERE CONCAT(u.nom, ' ', u.prenom, ' ', u.cin, ' ', u.email) LIKE %?1%")
    public List<UsersEntity> search(String keyword);

    @Query("SELECT r.idreservation,r.status,r.currentdate,u.iduser,u.nom,u.prenom FROM ReservationEntity r,UsersEntity u WHERE r.iduser=u.iduser and r.status = false")
    UsersEntity findUsersEntityByApprenantsByIduserFalse();

//    public List<String> findUsersEntityByIdroleAndRole(String role);
}
