package com.project.orange.service;

import com.project.orange.entity.user.Salt;
import com.project.orange.entity.user.Users;
import com.project.orange.repository.user.SaltRepository;
import com.project.orange.repository.user.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SaltRepository saltRepository;

    @Autowired
    private SaltUtil saltUtil;

    @Override
    public void signUpUser(Users user){
        String password = user.getPassword();
        String salt = saltUtil.genSalt();
        log.info(salt);
        user.setSalt(new Salt(salt));
        user.setPassword(saltUtil.encodePassword(salt, password));
        userRepository.save(user);
    }

    @Override
    public Users loginUser(String username, String  password) throws Exception{
        Users user = userRepository.findByUsername(username);
        if(user == null) throw new Exception("멤버가 조회되지 않습니다.");
        String salt = user.getSalt().getSalt();
        password = saltUtil.encodePassword(salt,password);
        if(!user.getPassword().equals(password))
            throw new Exception("비밀번호가 틀립니다.");
        return user;
    }

}
