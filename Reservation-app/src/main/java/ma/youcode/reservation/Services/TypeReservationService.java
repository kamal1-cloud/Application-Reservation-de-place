package ma.youcode.reservation.Services;

import ma.youcode.reservation.DAO.TypeReservationRepository;
import ma.youcode.reservation.DAO.UsersRepository;
import ma.youcode.reservation.Models.TypereservationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeReservationService {
    @Autowired
    private TypeReservationRepository typeReservationRepository;

    public void save(TypereservationEntity typereservationEntity) {
        typeReservationRepository.save(typereservationEntity);
    }
    public void delete(Long id) {
        typeReservationRepository.deleteById(id);
    }
    public TypereservationEntity get(Long id) {
        return typeReservationRepository.findById(id).get();
    }




}
