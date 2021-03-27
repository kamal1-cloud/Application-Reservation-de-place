package ma.youcode.reservation.Models;

import javax.persistence.*;

@Entity
@Table(name = "apprenant")
public class ApprenantEntity extends UsersEntity{
    private Boolean status;
    private Integer ndereservation;
    private Long iduser;
    private UsersEntity usersByIduser;

    @Basic
    @Column(name = "status",insertable=false)
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ApprenantEntity() {
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

        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (ndereservation != null ? !ndereservation.equals(that.ndereservation) : that.ndereservation != null)
            return false;
        if (iduser != null ? !iduser.equals(that.iduser) : that.iduser != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (ndereservation != null ? ndereservation.hashCode() : 0);
        result = 31 * result + (iduser != null ? iduser.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "iduser", referencedColumnName = "iduser", insertable = false, updatable = false)
    public UsersEntity getUsersByIduser() {
        return usersByIduser;
    }

    public void setUsersByIduser(UsersEntity usersByIduser) {
        this.usersByIduser = usersByIduser;
    }
}
