package ma.youcode.reservation.Security;

import ma.youcode.reservation.Models.UsersEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;

public class MyUserDetails implements UserDetails {

    private UsersEntity user;

    public MyUserDetails(UsersEntity user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if(this.getStatus() == false) return false;
        return true;
    }
    public Boolean getStatus(){
        return user.getStatus();
    }
    public String getNom(){
        return user.getNom();
    }
    public String getPrenom(){
        return user.getPrenom();
    }
    public String getCin(){
        return user.getCin();
    }
    public Timestamp getCurrentdate(){
        return user.getCurrentdate();
    }

    public UsersEntity getUser() {
        return user;
    }

}
