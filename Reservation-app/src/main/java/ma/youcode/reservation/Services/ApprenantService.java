package ma.youcode.reservation.Services;

import ma.youcode.reservation.DAO.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprenantService {

    @Autowired
    ApprenantRepository apprenantRepository;

    public void getUsersEntityByStatusFalse(){
        apprenantRepository.getUsersEntityByStatusFalse();
    }
    public void getUsersEntityByStatusTrue(){
        apprenantRepository.getUsersEntityByStatusTrue();
    }

}
