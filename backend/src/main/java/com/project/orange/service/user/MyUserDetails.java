package com.project.orange.service.user;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;

//UserDetails : Spring Security에서 사용자의 정보를 담는 인터페이스
//이 인터페이스를 구현하게 되면 Spring Security에서 구현한 클래스를 사용자 정보로 인식하고 인증 작업

//User에 해당하는 Model에 userDetails를 구현하여 SpringSecurity가 이해할 수 있는 형태의 User로 만들어주어야 함.
//이 클래스는 사용자의 정보를 모두 담아두는 클래스
@Getter
public class MyUserDetails implements UserDetails, Serializable {

    private static final long serialVersionUID = 174726374856727L;

    private Long userId;
    private String email;
    private String password;
    private String username;
    private String nickname;

    private Collection<GrantedAuthority> authorities;
    private boolean emailVerified;
    private boolean locked;
    
    //해당 유저의 권한 목록
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    
    //비밀번호
    @Override
    public String getPassword(){
        return password;
    }

    //PK값
    //이름을 리턴한다고 해놨지만, 계정의 아이디 혹은 이메일을 리턴한다.
   @Override
    public String getUsername(){
        return email;
    }

    //계정 만료 여부 : 만료 안 됨(true)
    //체크할 필요가 없으면 true
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정 잠김 여부 : 잠기지 않음 (true)
    //체크할 필요가 없으면 true
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //비밀번호 만료 여부 : 만료 안 됨(true)
    //체크할 필요가 없으면 true
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //사용자 활성화 여부 : 활성화 (true)
    //체크할 필요가 없으면 true
    @Override
    public boolean isEnabled() {
        //이메일이 인증되어 있고 계정이 잠겨있지 않으면 true
        return true;
    }


}
