package hu.bme.popit.ticketsystem.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/**").permitAll()
                .requestMatchers("/#/**").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/anonymous*")
                .anonymous()
                .requestMatchers("/login*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                //.loginPage("/login.html")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/#/tickets", true)
                .failureUrl("/login.html?error=true")
                //.failureHandler(authenticationFailureHandler())
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .deleteCookies("JSESSIONID");
        //.logoutSuccessHandler(logoutSuccessHandler());
/*        http.authorizeHttpRequests().anyRequest().permitAll()
                .and()
                .formLogin()
                .and()
                .httpBasic().and().csrf().disable();
        //http.cors().disable();
        http.headers().frameOptions().disable().crossOriginResourcePolicy();*/
        return http.build();
    }


}
