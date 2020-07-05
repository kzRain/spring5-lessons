package com.codeforce.product.config;

import com.codeforce.product.security.JpaUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import java.util.concurrent.TimeUnit;

import static com.codeforce.product.security.UserRole.*;
import static com.codeforce.product.security.UserPermission.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index.html").permitAll()
//                .antMatchers("/packs/**").hasRole(USER.name())
                .antMatchers(HttpMethod.DELETE, "/api/states/**").hasAuthority(STATE_WRITE.getPermission())
                .antMatchers(HttpMethod.POST, "/api/states/**").hasAuthority(STATE_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT, "/api/states/**").hasAuthority(STATE_WRITE.getPermission())
                .antMatchers(HttpMethod.GET, "/api/states/**").hasAnyRole(ADMIN.name(), MANAGER.name())
                .anyRequest()
                .authenticated()
                .and()
//                .httpBasic();
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/greeting", true)
                .and()
                .rememberMe()
                .tokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(21)).key("secret")
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me")
                .logoutSuccessUrl("/login");
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

//    @Bean
//    public UserDetailsService userDetailsManager() {
//        return new JpaUserDetailsService();
//    }
//

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
//                .roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthorities())
                .build();
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("user"))
//                .roles(USER.name())
                .authorities(USER.getGrantedAuthorities())
                .build();
        UserDetails manager = User.builder()
                .username("manager")
                .password(passwordEncoder.encode("manager"))
//                .roles(MANAGER.name())
                .authorities(MANAGER.getGrantedAuthorities())
                .build();
        return new InMemoryUserDetailsManager(
                admin,
                user,
                manager
        );
    }
}
