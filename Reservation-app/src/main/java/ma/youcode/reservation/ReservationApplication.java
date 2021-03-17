package ma.youcode.reservation;

import ma.youcode.reservation.DAO.ApprenantRepository;
import ma.youcode.reservation.DAO.ReservationRepository;
import ma.youcode.reservation.DAO.TypeReservationRepository;
import ma.youcode.reservation.DAO.UsersRepository;
import ma.youcode.reservation.Models.ApprenantEntity;
import ma.youcode.reservation.Models.TypereservationEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ReservationApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ReservationApplication.class, args);
        TypeReservationRepository typeReservationRepository = ctx.getBean(TypeReservationRepository.class);
      //  typeReservationRepository.deleteById(6);
      //  typeReservationRepository.save(new  TypereservationEntity("Test",90));
//       reservationRepository.updateReservationSetStatus(2L);
    //   apprenantRepository.save(new ApprenantEntity("Simo","Meguina","RR4655","amal@gmail.com","AZERTY",false));
////        roleRepository.save(new RoleEntity("Admin"));
    //   roleRepository.save(new RoleEntity("Apprenant"));
//        reservationRepository.getReservationEntityByStatus().forEach(r -> {
//            System.out.println(r.getIduser() +" "+ r.getStatus());
//        });
    }

}
