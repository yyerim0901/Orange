package com.project.orange.service.user;

//import com.project.orange.entity.user.SecurityUser;
import com.project.orange.entity.user.Users;
import com.project.orange.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository memberRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Users user = memberRepository.findByUsername(username);
//        if(user == null){
//            throw new UsernameNotFoundException(username + " : 사용자 존재하지 않음");
//        }
//
//        return new SecurityUser(user);
//    }
//}
