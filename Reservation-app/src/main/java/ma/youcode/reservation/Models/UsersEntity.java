package ma.youcode.reservation.Models;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Inheritance(strategy=InheritanceType.JOINED)
public class UsersEntity implements Serializable {
    private long iduser;
    private String nom;
    private String prenom;
    private String cin;
    private String email;
    private String password;
    private Timestamp currentdate;
    private Long idrole;
    private Collection<ApprenantEntity> apprenantsByIduser;
    private Collection<ReservationEntity> reservationsByIduser;
    private RoleEntity roleByIdrole;


    public UsersEntity(String nom, String prenom, String cin, String email, String password, Long idrole) {
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.email = email;
        this.password = password;
        this.idrole = idrole;
    }

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
//    @CreationTimestamp
    @Column(name="currentdate",insertable=false)
    public Timestamp getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(Timestamp currentdate) {
        this.currentdate = currentdate;
    }

    @Basic
    @Column(name = "idRole", insertable = false)
    public Long getIdrole() {
        return idrole;
    }

    public void setIdrole(Long idrole) {
        this.idrole = idrole;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (iduser != that.iduser) return false;
        if (!Objects.equals(nom, that.nom)) return false;
        if (!Objects.equals(prenom, that.prenom)) return false;
        if (!Objects.equals(cin, that.cin)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(password, that.password)) return false;
        if (!Objects.equals(currentdate, that.currentdate)) return false;
        if (!Objects.equals(idrole, that.idrole)) return false;

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
        result = 31 * result + (currentdate != null ? currentdate.hashCode() : 0);
        result = 31 * result + (idrole != null ? idrole.hashCode() : 0);
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

    @ManyToOne
    @JoinColumn(name = "idRole", referencedColumnName = "idRole", insertable = false, updatable = false)
    public RoleEntity getRoleByIdrole() {
        return roleByIdrole;
    }

    public void setRoleByIdrole(RoleEntity roleByIdrole) {
        this.roleByIdrole = roleByIdrole;
    }



//    private Collection<RoleEntity> roles;
//    public Collection<RoleEntity> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(Collection<RoleEntity> roles) {
//        this.roles = roles;
//    }

}
