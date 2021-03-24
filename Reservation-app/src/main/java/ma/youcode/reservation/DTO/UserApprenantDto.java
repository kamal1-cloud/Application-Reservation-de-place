package ma.youcode.reservation.DTO;

import java.sql.Timestamp;

public class UserApprenantDto {
    private long iduser;
    private String nom;
    private String prenom;
    private Timestamp currentdate;
    private Boolean status;
    private Integer ndereservation;

    public UserApprenantDto(long iduser, String nom, String prenom, Timestamp currentdate, Boolean status, Integer ndereservation) {
        this.iduser = iduser;
        this.nom = nom;
        this.prenom = prenom;

        this.currentdate = currentdate;
        this.status = status;
        this.ndereservation = ndereservation;
    }

    public long getIduser() {
        return iduser;
    }

    public void setIduser(long iduser) {
        this.iduser = iduser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Timestamp getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(Timestamp currentdate) {
        this.currentdate = currentdate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getNdereservation() {
        return ndereservation;
    }

    public void setNdereservation(Integer ndereservation) {
        this.ndereservation = ndereservation;
    }
}
