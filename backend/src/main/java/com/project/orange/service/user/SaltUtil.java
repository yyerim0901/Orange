package com.project.orange.service.user;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class SaltUtil {
    //솔트 함수를 관리하는 모듈
    //BCrypt : 암호화를 위한 해쉬함수
   public String encodePassword(String salt, String password){
        return BCrypt.hashpw(password,salt);
    }

    public String genSalt(){
        return BCrypt.gensalt();
    }
}
