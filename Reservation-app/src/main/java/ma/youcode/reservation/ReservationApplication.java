package ma.youcode.reservation;

import ma.youcode.reservation.DAO.ApprenantRepository;
import ma.youcode.reservation.DAO.UsersRepository;
import ma.youcode.reservation.Models.ApprenantEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ReservationApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ReservationApplication.class, args);
        ApprenantRepository apprenantRepository= ctx.getBean(ApprenantRepository.class);
    //   apprenantRepository.save(new ApprenantEntity("Simo","Meguina","RR4655","amal@gmail.com","AZERTY",false));
////        roleRepository.save(new RoleEntity("Admin"));
    //   roleRepository.save(new RoleEntity("Apprenant"));
//        apprenantRepository.findAll().forEach(r -> {
//            System.out.println(r.getIdrole());
//        });
    }

}