package com.project.orange.service.user;

//import com.project.orange.entity.user.SecurityUser;
import com.project.orange.entity.user.Users;
import com.project.orange.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//UserDetailService : 유저의 정보를 가져오는 인터페이스,
//                  Spring Security에서 유저의 정보를 불러오기 위해서 구현해야하는 인터페이스

//사용자의 정보를 담은 객체를 만든 뒤 (MyUserDetails) DB에서 유저 정보를 직접 가져오자.


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository memberRepository;

    //유저의 정보를 불러와 UsersDetails로 리턴
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = memberRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(username + " : 사용자 존재하지 않음");
        }

        return new MyUserDetails();
    }
}
