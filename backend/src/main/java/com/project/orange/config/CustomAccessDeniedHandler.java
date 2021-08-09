package com.project.orange.config;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.project.orange.entity.user.SecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

@Slf4j
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ObjectMapper objectMapper = new ObjectMapper();

        httpServletResponse.setStatus(200);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        ResponseEntity response = new ResponseEntity("error", HttpStatus.NOT_FOUND);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        SecurityUser member = (SecurityUser)authentication.getPrincipal();
//        Collection<GrantedAuthority> authorities = member.getAuthorities();

//        if(hasRole(authorities,UserRole.ROLE_NOT_PERMITTED.name())){
//            response.setMessage("사용자 인증메일을 받지 않았습니다.");
//        }

        PrintWriter out = httpServletResponse.getWriter();
        String jsonResponse = objectMapper.writeValueAsString(response);
        out.print(jsonResponse);

    }
    
    //얜 위에서 쓰는건데 안 써버리니까 지워도 되려나
    private boolean hasRole(Collection<GrantedAuthority> authorites, String role){
        return authorites.contains(new SimpleGrantedAuthority(role));
    }

}
