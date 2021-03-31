package ma.youcode.reservation.Services;

import ma.youcode.reservation.Repositories.ApprenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprenantService {

    @Autowired
    ApprenantRepository apprenantRepository;


//    public void activerLeCompte(Long id){
//        apprenantRepository.updateApprenantSetStatusToTrue(id);
//    }
//    public void desactiverLeCompte(Long id){
//        apprenantRepository.updateApprenantSetStatusToFalse(id);
//    }


}
