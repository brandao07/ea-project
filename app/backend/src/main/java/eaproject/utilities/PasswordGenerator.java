package eaproject.utilities;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.security.SecureRandom;

@Component
public class PasswordGenerator implements Serializable {
    private static final long serialVersionUID = 1L;

    private int passwordLength = 12;
    private String characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!";

    private final SecureRandom random = new SecureRandom();

    // No-argument constructor
    public PasswordGenerator() {
    }

    // Getter and Setter for passwordLength
    public int getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    // Getter and Setter for characterSet
    public String getCharacterSet() {
        return characterSet;
    }

    public void setCharacterSet(String characterSet) {
        this.characterSet = characterSet;
    }

    // Method to generate a random password
    public String generatePassword() {
        StringBuilder password = new StringBuilder(passwordLength);
        for (int i = 0; i < passwordLength; i++) {
            int index = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(index));
        }
        return password.toString();
    }

    public static void main(String[] args) {
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        System.out.println("Generated Password: " + passwordGenerator.generatePassword());
    }
}
