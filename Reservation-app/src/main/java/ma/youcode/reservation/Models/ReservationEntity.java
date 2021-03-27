package ma.youcode.reservation.Models;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "reservation")
public class ReservationEntity {
    private long idreservation;
    private Timestamp currentdate;
    private Boolean status;
    private Long iduser;
    private Long idtype;
    private UsersEntity usersByIduser;
    private TypereservationEntity typereservationByIdtype;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreservation")
    public long getIdreservation() {
        return idreservation;
    }

    public void setIdreservation(long idreservation) {
        this.idreservation = idreservation;
    }

    public ReservationEntity( Long iduser, Long idtype, UsersEntity usersByIduser) {

        this.iduser = iduser;
        this.idtype = idtype;
        this.usersByIduser = usersByIduser;
    }


    @Basic
    @Column(name="currentdate",insertable=false)
    public Timestamp getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(Timestamp currentdate) {
        this.currentdate = currentdate;
    }

    @Basic
    @Column(name = "status",insertable=false)
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Basic
    @Column(name = "iduser")
    public Long getIduser() {
        return iduser;
    }

    public void setIduser(Long iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "idtype")
    public Long getIdtype() {
        return idtype;
    }

    public void setIdtype(Long idtype) {
        this.idtype = idtype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReservationEntity that = (ReservationEntity) o;

        if (idreservation != that.idreservation) return false;
        if (currentdate != null ? !currentdate.equals(that.currentdate) : that.currentdate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (iduser != null ? !iduser.equals(that.iduser) : that.iduser != null) return false;
        if (idtype != null ? !idtype.equals(that.idtype) : that.idtype != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idreservation ^ (idreservation >>> 32));
        result = 31 * result + (currentdate != null ? currentdate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (iduser != null ? iduser.hashCode() : 0);
        result = 31 * result + (idtype != null ? idtype.hashCode() : 0);
        return result;
    }

    public ReservationEntity() {
    }

    @ManyToOne
    @JoinColumn(name = "iduser", referencedColumnName = "iduser", insertable = false, updatable = false)
    public UsersEntity getUsersByIduser() {
        return usersByIduser;
    }

    public void setUsersByIduser(UsersEntity usersByIduser) {
        this.usersByIduser = usersByIduser;
    }

    @ManyToOne
    @JoinColumn(name = "idtype", referencedColumnName = "idtype", insertable = false, updatable = false)
    public TypereservationEntity getTypereservationByIdtype() {
        return typereservationByIdtype;
    }

    public void setTypereservationByIdtype(TypereservationEntity typereservationByIdtype) {
        this.typereservationByIdtype = typereservationByIdtype;
    }
}
