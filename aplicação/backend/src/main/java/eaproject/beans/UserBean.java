package eaproject.beans;

import eaproject.beans.locals.UserLocal;
import eaproject.dao.User;
import eaproject.dao.UserDAO;
import eaproject.dto.AuthenticationDTO;
import eaproject.dto.UserDTO;
import eaproject.utilities.Utilities;
import eaproject.utilities.JwtTokenUtil;
import org.orm.PersistentException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "UserEJB")
@Local(UserLocal.class)
@Component
public class UserBean {
    public String loginUser(AuthenticationDTO userInput) throws UsernameNotFoundException, PersistentException {
        User user = UserDAO.loadUserByQuery("email = '" + userInput.getEmail() + "'", null);
        if (user != null && user.getUserId() > 0 && user.getIsActive()) {
            // Instantiate BCryptPasswordEncoder
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(userInput.getPassword(), user.getPassword())) {
                return JwtTokenUtil.createToken(user);
            } else {
                throw new BadCredentialsException("Invalid email or password");
            }
        } else {
            throw new UsernameNotFoundException("User not found with email address: " + userInput.getEmail());
        }
    }

    public User[] getAllUsers() {
        try {
            return UserDAO.listUserByQuery(null,null);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    public boolean createUser(UserDTO userDTO) {
        try {
            // Convert UserDTO to User entity
            User user = Utilities.convertToDAO(userDTO, User.class);
            // Hash the password using BCryptPasswordEncoder
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashedPassword); // Set the hashed password
            // Save user to database using DAO
            return UserDAO.save(user);
        } catch (PersistentException e) {
            throw new RuntimeException(e);
        }
    }
}
