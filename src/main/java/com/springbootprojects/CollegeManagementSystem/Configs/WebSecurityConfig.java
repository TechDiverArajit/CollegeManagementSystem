package com.springbootprojects.CollegeManagementSystem.Configs;

import com.springbootprojects.CollegeManagementSystem.Filters.JwtAuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    public WebSecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeHttpRequests(authorization -> authorization
                        .requestMatchers("/AdmissionRecord","/auth/**").permitAll()
//                        .requestMatchers("/AdmissionRecord/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated())
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
//                .formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }

//    @Bean
//    UserDetailsService inMemoryUserDetailsService(){
//        UserDetails NormalUser = User
//                .withUsername("arijit")
//                .roles("USER")
//                .password(passwordEncoder().encode("1234"))
//                .build();
//
//        UserDetails AdminUser = User
//                .withUsername("admin")
//                .roles("ADMIN")
//                .password(passwordEncoder().encode("admin1234"))
//                .build();
//        return new InMemoryUserDetailsManager(NormalUser,AdminUser);
//    }





    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
