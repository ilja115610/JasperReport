package ee.airest.airest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final String credentialsLocation;

    private final BCryptPasswordEncoder passwordEncoder;


    public SecurityConfig(@Value("${security.credentials.location}") String credentialsLocation,
                          BCryptPasswordEncoder passwordEncoder) {
        this.credentialsLocation = credentialsLocation;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManagerConfigurer configurer = auth.inMemoryAuthentication();

        Files.readAllLines(Paths.get(credentialsLocation)).forEach(
                user -> {
                    String[] parts = user.split("\\s+",2);
                    configurer.withUser(parts[0]).password(passwordEncoder.encode(parts[1])).roles("USER");
                }
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
        .antMatchers("/js/*", "/static/css/css/*","/resources/**","/static/**","/css/**","/img/**").permitAll()
                .antMatchers( "/favicon.ico").permitAll()
                .antMatchers("/**").hasRole("USER")
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/form",true).permitAll()
                .and().logout().logoutSuccessUrl("/login").permitAll();
    }
}

