package eaproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
    private static final int BCRYPT_WORK_FACTOR = 10; // Use a safe default work factor
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Configure BCryptPasswordEncoder with a specific work factor
        return new BCryptPasswordEncoder(BCRYPT_WORK_FACTOR);
    }
}