package ma.youcode.reservation.Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "role")
public class RoleEntity implements Serializable {
    private Long id;
    private int idrole;
    private String rolenom;
    private Collection<UsersEntity> usersByIdrole;



    @Id
    @GeneratedValue
    @Column(name = "idrole")
    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    @Basic
    @Column(name = "rolenom")
    public String getRolenom() {
        return rolenom;
    }

    public void setRolenom(String rolenom) {
        this.rolenom = rolenom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleEntity that = (RoleEntity) o;

        if (idrole != that.idrole) return false;
        if (rolenom != null ? !rolenom.equals(that.rolenom) : that.rolenom != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idrole;
        result = 31 * result + (rolenom != null ? rolenom.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "roleByIdrole")
    public Collection<UsersEntity> getUsersByIdrole() {
        return usersByIdrole;
    }

    public void setUsersByIdrole(Collection<UsersEntity> usersByIdrole) {
        this.usersByIdrole = usersByIdrole;
    }
}
