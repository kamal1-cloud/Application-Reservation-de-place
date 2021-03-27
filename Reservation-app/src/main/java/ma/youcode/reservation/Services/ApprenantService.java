package ma.youcode.reservation.Services;

import ma.youcode.reservation.DAO.ApprenantRepository;
import ma.youcode.reservation.Models.ApprenantEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprenantService {

    @Autowired
    ApprenantRepository apprenantRepository;


    public void activerLeCompte(Long id){
        apprenantRepository.updateApprenantSetStatusToTrue(id);
    }
    public void desactiverLeCompte(Long id){
        apprenantRepository.updateApprenantSetStatusToFalse(id);
    }


}
