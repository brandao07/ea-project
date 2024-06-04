package eaproject.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter {

    private final JwtTokenUtil jwtUtil;
    private final ObjectMapper mapper;

    public JwtAuthorizationFilter(JwtTokenUtil jwtUtil, ObjectMapper mapper) {
        this.jwtUtil = jwtUtil;
        this.mapper = mapper;
    }

    /**
     * The main filtering logic that is executed for each request.
     *
     * @param request     The HTTP request.
     * @param response    The HTTP response.
     * @param filterChain The filter chain.
     * @throws javax.servlet.ServletException If a servlet-specific error occurs.
     * @throws IOException      If an I/O error occurs.
     */
    @Override
    protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain) throws javax.servlet.ServletException, IOException {
        Map<String, Object> errorDetails = new HashMap<>();

        try {
            // Resolve the JWT token from the request.
            String accessToken = jwtUtil.resolveToken(request);
            if (accessToken == null) {
                // If no token is found, continue the filter chain.
                filterChain.doFilter(request, response);
                return;
            }

            System.out.println("token : " + accessToken);

            // Resolve the claims from the JWT token.
            Claims claims = jwtUtil.resolveClaims(request);

            if (claims != null && jwtUtil.validateClaims(claims)) {
                // Extract the email (subject) from the claims.
                String email = claims.get("email", String.class);
                System.out.println("email : " + email);

                // Extract authorities (roles) from the claims.
                Collection<GrantedAuthority> authorities = getAuthoritiesFromClaims(claims);

                // Create an authentication object with the email and authorities.
                Authentication authentication = new UsernamePasswordAuthenticationToken(email, "", authorities);

                // Set the authentication in the security context.
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during authentication.
            errorDetails.put("message", "Authentication Error");
            errorDetails.put("details", e.getMessage());
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            // Write the error details to the response.
            mapper.writeValue(response.getWriter(), errorDetails);
        }

        // Continue the filter chain.
        filterChain.doFilter(request, response);
    }

    /**
     * Extracts authorities (e.g., role) from the JWT claims.
     *
     * @param claims The JWT claims.
     * @return A collection of granted authorities.
     */
    private Collection<GrantedAuthority> getAuthoritiesFromClaims(Claims claims) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        String role = (String) claims.get("role");

        // Ensure the role starts with "ROLE_"
        if (role != null && !role.startsWith("ROLE_")) {
            role = "ROLE_" + role;
        }

        authorities.add(new SimpleGrantedAuthority(role));
        return authorities;
    }
}