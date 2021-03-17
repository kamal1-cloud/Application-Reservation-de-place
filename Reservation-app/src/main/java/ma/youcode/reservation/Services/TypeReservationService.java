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

    public void saveType(TypereservationEntity typereservationEntity) {
        typeReservationRepository.save(typereservationEntity);
    }
    public void deleteType(Integer id) {
        typeReservationRepository.deleteById(id);
    }
    public TypereservationEntity get(Integer id) {
        return typeReservationRepository.findById(id).get();
    }




}
