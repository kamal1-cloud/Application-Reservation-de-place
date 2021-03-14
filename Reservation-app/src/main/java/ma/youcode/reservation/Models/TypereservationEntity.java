package ma.youcode.reservation.Models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "typereservation", schema = "public", catalog = "reservationDb")
public class TypereservationEntity {
    private Long id;
    private int idtype;
    private String typenom;
    private Integer nombredeplace;
    private Collection<ReservationEntity> reservationsByIdtype;

    @Id
    @GeneratedValue
    @Column(name = "idtype")
    public int getIdtype() {
        return idtype;
    }

    public void setIdtype(int idtype) {
        this.idtype = idtype;
    }

    @Basic
    @Column(name = "typenom")
    public String getTypenom() {
        return typenom;
    }

    public void setTypenom(String typenom) {
        this.typenom = typenom;
    }

    @Basic
    @Column(name = "nombredeplace")
    public Integer getNombredeplace() {
        return nombredeplace;
    }

    public void setNombredeplace(Integer nombredeplace) {
        this.nombredeplace = nombredeplace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypereservationEntity that = (TypereservationEntity) o;

        if (idtype != that.idtype) return false;
        if (typenom != null ? !typenom.equals(that.typenom) : that.typenom != null) return false;
        if (nombredeplace != null ? !nombredeplace.equals(that.nombredeplace) : that.nombredeplace != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idtype;
        result = 31 * result + (typenom != null ? typenom.hashCode() : 0);
        result = 31 * result + (nombredeplace != null ? nombredeplace.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "typereservationByIdtype")
    public Collection<ReservationEntity> getReservationsByIdtype() {
        return reservationsByIdtype;
    }

    public void setReservationsByIdtype(Collection<ReservationEntity> reservationsByIdtype) {
        this.reservationsByIdtype = reservationsByIdtype;
    }
}
