package ma.youcode.reservation.Services;

import ma.youcode.reservation.DAO.ReservationRepository;
import ma.youcode.reservation.Models.ReservationEntity;
import ma.youcode.reservation.Models.TypereservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationServices {

    @Autowired
    ReservationRepository reservationRepository;

    public void save(ReservationEntity type) {
        reservationRepository.save(type);
    }
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }

    public ReservationEntity get(Long id) {
        return reservationRepository.findById(id).get();
    }
    public List<ReservationEntity> getReservationEntityByStatus(){
        return reservationRepository.getReservationEntityByStatus();
    }

    public void updateStatus(Long id){
        reservationRepository.updateReservationSetStatus(id);
    }
}
