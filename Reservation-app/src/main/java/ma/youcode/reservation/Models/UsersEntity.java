package ma.youcode.reservation.Models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "users")
@Inheritance(strategy=InheritanceType.JOINED)
public class UsersEntity {
    private long iduser;
    private String nom;
    private String prenom;
    @Size(min = 6, max = 7)
    private String cin;
    @Email(message = "Please enter a valid e-mail address")
    private String email;
    @NotBlank
    @Size(min = 6, max = 15)
    private String password;
    private String role;
    private Timestamp currentdate;
    private Collection<ApprenantEntity> apprenantsByIduser;
    private Collection<ReservationEntity> reservationsByIduser;

    public UsersEntity() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "cin")
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role",insertable=false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "currentdate",insertable=false)
    public Timestamp getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(Timestamp currentdate) {
        this.currentdate = currentdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (iduser != that.iduser) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (cin != null ? !cin.equals(that.cin) : that.cin != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (currentdate != null ? !currentdate.equals(that.currentdate) : that.currentdate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (iduser ^ (iduser >>> 32));
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (cin != null ? cin.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (currentdate != null ? currentdate.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "usersByIduser")
    public Collection<ApprenantEntity> getApprenantsByIduser() {
        return apprenantsByIduser;
    }

    public void setApprenantsByIduser(Collection<ApprenantEntity> apprenantsByIduser) {
        this.apprenantsByIduser = apprenantsByIduser;
    }

    @OneToMany(mappedBy = "usersByIduser")
    public Collection<ReservationEntity> getReservationsByIduser() {
        return reservationsByIduser;
    }

    public void setReservationsByIduser(Collection<ReservationEntity> reservationsByIduser) {
        this.reservationsByIduser = reservationsByIduser;
    }
}
