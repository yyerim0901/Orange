package com.project.orange.config;

import com.project.orange.entity.user.Users;
import com.project.orange.service.user.MyUserDetailsService;
import com.project.orange.service.user.CookieUtil;
import com.project.orange.service.user.JwtUtil;
import com.project.orange.service.user.RedisUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    //SecurityContextPersistenceFilter : SecurityContext 객체를 로딩하여 SecurityContextHolder에 저장하고 요청이 끝나면 삭제
    //LogoutFilter : 지정한 경로의 요청이 들어오면 사용자를 로그아웃시킴
    //UsernamePasswordAuthennticationFilter : 로그인 요청이 들어오면 아이디/비밀번호 기반의 인증을 수행한다.
    //FilterSecurityInterceptor : 인증에 성공한 사용자가 해당 리소스에 접근할 권한이 있는지를 검증

    //JWT 토큰의 인증 정보를 현재 쓰레드의 SecurityContext 에 저장하는 역할 수행

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CookieUtil cookieUtil;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {

        final Cookie jwtToken = cookieUtil.getCookie(httpServletRequest,JwtUtil.ACCESS_TOKEN_NAME);
        //1. 쿠키에 access token을 들고온다.

        String email = null; //여기 들어가는게 email이 맞을까,,?
        String jwt = null;
        String refreshJwt = null;
        String refreshUname = null;

        try{
            if(jwtToken != null){ //2. 액세스 토큰이 있으면 사용자 정보를 들고오면 됨
                jwt = jwtToken.getValue();
                email = jwtUtil.getEmail(jwt); //jwtUtil에서는 username으로 가져온다고 되어있음
            }
            if(email!=null){
                UserDetails userDetails = userDetailsService.loadUserByUsername(email);
                //UserDetailService에서도 username으로 들고온다고 되어 있음 -? MyUserDetails로 바꿔야하지 않나?

                if(jwtUtil.validateToken(jwt,userDetails)){ //액세스 토큰이 유효한 토큰인지 검사한다.
                    //UsernamePasswordAuthenticationFilter 이거 spring security filter
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                            = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());//getAuthorities...?

                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    //SecurityContextHolder안에 SecurityContext 객체가 있음
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        }catch (ExpiredJwtException e){
            //액세스 토큰이 없는 경우
            Cookie refreshToken = cookieUtil.getCookie(httpServletRequest,JwtUtil.REFRESH_TOKEN_NAME);
            if(refreshToken!=null){
                refreshJwt = refreshToken.getValue();
            }
        }catch(Exception e){

        }

        //리프레시 토큰이 있을 때
        try{
            if(refreshJwt != null){
                //key가 refresh token이고, key값을 통해 redis에서 value(email)값을 받아서 refreshUname에 저장
                refreshUname = redisUtil.getData(refreshJwt);

                if(refreshUname.equals(jwtUtil.getEmail(refreshJwt))){ //JwtUtil에 getEmail 아무리 봐도 고쳐야 할 것 같은데 ㅎ
                    UserDetails userDetails = userDetailsService.loadUserByUsername(refreshUname);
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                            = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

                    Users user = new Users();
                    user.setEmail(refreshUname); //여기서는 또 email이란 말이지
                    //리프레시 토큰으로 받은 value값인 email을 setEmail로 넣고, 해당 유저에 대한 액세스 토큰을 만든다.
                    String newToken =jwtUtil.generateToken(user);

                    Cookie newAccessToken = cookieUtil.createCookie(JwtUtil.ACCESS_TOKEN_NAME,newToken);
                    httpServletResponse.addCookie(newAccessToken);
                }
            }
        }catch(ExpiredJwtException e){

        }

        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
