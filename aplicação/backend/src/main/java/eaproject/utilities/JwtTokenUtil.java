package eaproject.utilities;

import eaproject.dao.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * Utility class for handling JWT token operations.
 */
@Component
public class JwtTokenUtil {

    private static String ISSUER;
    private static String SUBJECT;
    private static String SECRET_KEY;
    private static final long ACCESS_TOKEN_VALIDITY = 60 * 60 * 1000; // 1 hour in milliseconds
    private static final String TOKEN_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";

    /**
     * Constructor to initialize JwtTokenUtil with values from application properties.
     *
     * @param secretKey The secret key used for signing the JWT token.
     * @param issuer    The issuer of the JWT token.
     * @param subject   The subject of the JWT token.
     */
    public JwtTokenUtil(@Value("${jwt.secret}") String secretKey,
                        @Value("${jwt.issuer}") String issuer,
                        @Value("${jwt.subject}") String subject) {
        this.SECRET_KEY = secretKey;
        this.ISSUER = issuer;
        this.SUBJECT = subject;
    }

    /**
     * Creates a JWT token for the given user.
     *
     * @param user The user for whom the token is being created.
     * @return The created JWT token as a String.
     * @throws PersistentException If an error occurs during the token creation process.
     */
    public static String createToken(User user) throws PersistentException {

        Date now = new Date();
        Date expiration = new Date(now.getTime() + ACCESS_TOKEN_VALIDITY);

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        // Building the JWT token
        String token = Jwts.builder()
                .setIssuer(ISSUER)
                .setIssuedAt(now)
                .setSubject(SUBJECT)
                .claim("idUser", user.getUserId())
                .claim("name", user.getName())
                .claim("email", user.getEmail())
                .claim("password", user.getPassword())
                .claim("isActive", user.getIsActive())
                .claim("registerDate", user.getRegisterDate())
                .claim("picture", user.getPhotographypath())
                .claim("role", user.getRole().getName())
                .setExpiration(expiration)
                .signWith(signingKey, signatureAlgorithm)
                .compact();

        return TOKEN_PREFIX + token;
    }

    /**
     * Decodes a JWT token to extract claims.
     *
     * @param jwt The JWT token to be decoded.
     * @return The claims extracted from the JWT token.
     */
    public Claims decodeToken(String jwt) {
        try {
            return Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                    .parseClaimsJws(jwt)
                    .getBody();
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Validates the claims extracted from a JWT token.
     *
     * @param claims The claims to be validated.
     * @return True if the claims are valid, false otherwise.
     * @throws AuthenticationException If an error occurs during validation.
     */
    public boolean validateClaims(Claims claims) throws AuthenticationException {
        try {
            return claims.getExpiration().after(new Date());
        } catch (Exception ex) {
            throw ex;
        }
    }

    /**
     * Resolves and decodes the JWT token from the HTTP request.
     *
     * @param req The HTTP request containing the JWT token.
     * @return The claims extracted from the JWT token.
     */
    public Claims resolveClaims(HttpServletRequest req) {
        String token = resolveToken(req);
        if (token != null) {
            try {
                return decodeToken(token);
            } catch (ExpiredJwtException ex) {
                req.setAttribute("expired", ex.getMessage());
                throw ex;
            } catch (Exception ex) {
                req.setAttribute("invalid", ex.getMessage());
                throw ex;
            }
        }
        return null;
    }

    /**
     * Resolves the JWT token from the HTTP request.
     *
     * @param request The HTTP request containing the JWT token.
     * @return The JWT token as a String.
     */
    public String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(TOKEN_HEADER);
        if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
            return bearerToken.substring(TOKEN_PREFIX.length());
        }
        return null;
    }
}
