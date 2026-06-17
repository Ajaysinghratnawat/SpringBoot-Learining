package com.ajay.SpringSecurity.config;

import com.ajay.SpringSecurity.entities.enums.Permissions;
import com.ajay.SpringSecurity.filter.JwtAuthFilter;
import com.ajay.SpringSecurity.handlers.oauth2SuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.ajay.SpringSecurity.entities.enums.Role.ADMIN;
import static com.ajay.SpringSecurity.entities.enums.Role.CREATER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final oauth2SuccessHandler oauth2SuccessHandler;

    private static final String[] publicRoutes= {
            "/error","/auth/**","/home.html"
    };

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.authorizeHttpRequests(auth->auth
                .requestMatchers(publicRoutes).permitAll()
                        .requestMatchers("/posts/**").authenticated()
//                        .requestMatchers(HttpMethod.GET,"/Posts/**").permitAll()
//                        .requestMatchers(HttpMethod.POST,"/posts/**").hasAnyRole(ADMIN.name(), CREATER.name())
////                .requestMatchers("/posts/**").authenticated()
//                        .requestMatchers(HttpMethod.POST,"/posts/**").hasAnyAuthority(Permissions.POST_CREATE.name())
//                        .requestMatchers(HttpMethod.GET,"/posts/**").hasAuthority(Permissions.POST_VIEW.name())
//                        .requestMatchers(HttpMethod.PUT,"/posts/**").hasAuthority(Permissions.POST_UPDATE.name())
//                        .requestMatchers(HttpMethod.DELETE,"/posts/**").hasAuthority(Permissions.POST_DELETE.name())
                .anyRequest().authenticated())
                .csrf(csrfConfig->csrfConfig.disable())
                .sessionManagement(sessionConfig->sessionConfig
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .oauth2Login(oauth2Config->oauth2Config
                        .failureUrl("/login?error=true")
                        .successHandler(oauth2SuccessHandler));
//        httpSecurity.formLogin(Customizer.withDefaults()); //Not authrize any request
        return httpSecurity.build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }


//    @Bean
//    UserDetailsService myInMemoryUserDetailsService(){
//        UserDetails normalUser = User.withUsername("ajay").password(passwordEncoder().encode("pwd")).roles("USER").build();
//        UserDetails adminUser = User.withUsername("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(normalUser,adminUser);
//    }


}
