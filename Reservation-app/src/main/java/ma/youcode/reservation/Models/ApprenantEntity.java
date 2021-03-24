package ma.youcode.reservation.Models;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "apprenant")
public class ApprenantEntity extends UsersEntity{

    private Boolean status;
    private Integer ndereservation;
    private Long iduser;
    private UsersEntity usersByIduser;




    public ApprenantEntity() {

    }
    public ApprenantEntity(String nom, String prenom, String cin, String email, String password, Boolean status) {
        super(nom, prenom, cin, email, password,2L);
        this.status = status;
    }

    @Basic
    @Column(name = "status" ,insertable=false)
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "ndereservation",insertable=false)
    public Integer getNdereservation() {
        return ndereservation;
    }

    public void setNdereservation(Integer ndereservation) {
        this.ndereservation = ndereservation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApprenantEntity that = (ApprenantEntity) o;

        if (!Objects.equals(status, that.status)) return false;
        if (!Objects.equals(ndereservation, that.ndereservation))
            return false;
        if (!Objects.equals(iduser, that.iduser)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (ndereservation != null ? ndereservation.hashCode() : 0);
        result = 31 * result + (iduser != null ? iduser.hashCode() : 0);
        return result;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "iduser", referencedColumnName = "iduser" , insertable = false, updatable = false)
    public UsersEntity getUsersByIduser() {
        return usersByIduser;
    }

    public void setUsersByIduser(UsersEntity usersByIduser) {
        this.usersByIduser = usersByIduser;
    }

}
