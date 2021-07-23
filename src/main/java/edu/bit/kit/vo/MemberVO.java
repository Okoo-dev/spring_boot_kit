package edu.bit.kit.vo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberVO implements UserDetails{
    private String userId;
    private String password;
    private int enabled;
    private String authName;
    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private Collection<? extends GrantedAuthority> authority;
    
    
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String getPassword() {
        return password;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Override
    public String getUsername() {
        return  userId;
    }
    

    public void setAuthName(String authName) {
        this.authName = authName;
    }
    
    public String getAuthName() {
        return authName;
    }
    
    public void setAuthority(Collection<? extends GrantedAuthority> authority) {
        this.authority = authority;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authority;
    }
    
    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
    @Override
    public boolean isEnabled() {
        
        return enabled==1?true:false;
    }
    
    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }
    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }
    
   
   

}
