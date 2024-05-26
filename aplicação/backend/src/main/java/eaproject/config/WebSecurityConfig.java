package eaproject.config;

import eaproject.utilities.JwtAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtAuthorizationFilter jwtAuthorizationFilter;

    public WebSecurityConfig(JwtAuthorizationFilter jwtAuthorizationFilter) {
        this.jwtAuthorizationFilter = jwtAuthorizationFilter;
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // Configure CORS and CSRF
        httpSecurity.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
        httpSecurity.csrf().disable();

        // Configure endpoint security
        httpSecurity.authorizeRequests()
                // Allow access to login and register endpoints without authentication
                .antMatchers("/Login", "/Register").permitAll()
                // Require authentication for all other endpoints
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}