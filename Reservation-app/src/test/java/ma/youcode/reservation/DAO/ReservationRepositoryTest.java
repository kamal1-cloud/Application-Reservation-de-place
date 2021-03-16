package ma.youcode.reservation.DAO;

import ma.youcode.reservation.Models.ReservationEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ReservationRepositoryTest {
    @Autowired
    ReservationRepository reservationRepository;

    @Test
    void getReservationEntityByStatus() {

        List<ReservationEntity> reservationEntities = reservationRepository.getReservationEntityByStatus();
        assertNotNull(reservationEntities);

    }

    @Test
    void updateReservationSetStatus() {
    }
}