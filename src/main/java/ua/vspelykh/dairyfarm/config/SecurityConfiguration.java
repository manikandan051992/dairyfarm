package ua.vspelykh.dairyfarm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    public AuthenticationManagerBuilder auth;

    @Autowired
    public SecurityConfiguration(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN")
                .and()
                .withUser("owner").password("owner").roles("OWNER")
                .and()
                .withUser("user").password("user").roles("USER")
                .and()
                .withUser("vet").password("vet").roles("VET");
    }

    @Bean
    @SuppressWarnings("java:S1874")
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .formLogin()
                .loginProcessingUrl("/login").permitAll()
                .defaultSuccessUrl("/")
                .and()
                .authorizeRequests()
                .antMatchers("/", "/index", "/actuator/**", "/any/**").permitAll()
                .antMatchers("/role/**").authenticated()
                .and()
                .logout(logout -> logout.logoutUrl("/logout").permitAll())
                .cors()
                .disable()
                .csrf()
                .disable()
                .build();
    }
}
