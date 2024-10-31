package se.lexicon.marketplaceapi.service;

import org.apache.catalina.startup.UserDatabase;
import org.hibernate.validator.internal.engine.groups.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.marketplaceapi.dto.UserDTO;
import se.lexicon.marketplaceapi.model.User;
import se.lexicon.marketplaceapi.repository.UserRepository;

import javax.management.relation.Role;
import java.util.Iterator;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserDTO userDTO) throws UserAlreadyExistsException {
        Optional<se.lexicon.marketplaceapi.model.User> existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User with email already exists.");
        }

        User user = null;
        user.getName();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword()); // Ideally, encrypt the password
        return userRepository.save(user);
    }

    public User authenticateUser(String email, String password) throws InvalidCredentialsException {
        User user = userRepository.findByEmail(email)
                .orElseThrow();
        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid email or password.");
        }
        return user;
    }

    private static class UserAlreadyExistsException extends Throwable {
        public UserAlreadyExistsException(String s) {
        }
    }

    public static class InvalidCredentialsException extends Throwable {
        public InvalidCredentialsException(String s) {
        }
    }
}
