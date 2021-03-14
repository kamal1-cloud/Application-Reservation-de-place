package ma.youcode.reservation.DAO;

import ma.youcode.reservation.Models.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    @Query(" select u from UsersEntity u " +
            " where u.email = ?1")
    Optional<UsersEntity> findUsersEntityByEmail(String email);

    UsersEntity findByEmail(String email);
}
