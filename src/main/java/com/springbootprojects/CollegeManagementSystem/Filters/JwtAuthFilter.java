package com.springbootprojects.CollegeManagementSystem.Filters;

import com.springbootprojects.CollegeManagementSystem.Entities.User;
import com.springbootprojects.CollegeManagementSystem.Services.JwtService;
import com.springbootprojects.CollegeManagementSystem.Services.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserService userService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String requestTokenHeader = request.getHeader("authorization");
        if(requestTokenHeader==null || !requestTokenHeader.startsWith("bearer")){
            filterChain.doFilter(request,response);
            return;
        }

        String Token = requestTokenHeader.split("bearer ")[1];

        Long id = jwtService.getUserIdWithToken(Token);
        if(id!=null && SecurityContextHolder.getContext().getAuthentication()==null){
            User user = userService.getUserWithId(id);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    user.getEmailID() ,
                    user.getPassword());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request,response);







    }


}
