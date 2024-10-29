package se.lexicon.marketplaceapi.service;

import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.User;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.marketplaceapi.dto.UserDTO;
import se.lexicon.marketplaceapi.repository.UserRepository;

import java.util.Iterator;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserDTO userDTO) throws UserAlreadyExistsException {
        Optional<User> existingUser = userRepository.findByEmail(userDTO.getEmail());
        if (existingUser.isPresent()) {
            throw new UserAlreadyExistsException("User with email already exists.");
        }
        User user = new User() {
            @Override
            public boolean equals(Object another) {
                return false;
            }

            @Override
            public String toString() {
                return "";
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public String getName() {
                return "";
            }

            @Override
            public String getFullName() {
                return "";
            }

            @Override
            public void setFullName(String s) {

            }

            @Override
            public Iterator<Group> getGroups() {
                return null;
            }

            @Override
            public String getPassword() {
                return "";
            }

            @Override
            public void setPassword(String s) {

            }

            @Override
            public Iterator<Role> getRoles() {
                return null;
            }

            @Override
            public UserDatabase getUserDatabase() {
                return null;
            }

            @Override
            public String getUsername() {
                return "";
            }

            @Override
            public void setUsername(String s) {

            }

            @Override
            public void addGroup(Group group) {

            }

            @Override
            public void addRole(Role role) {

            }

            @Override
            public boolean isInGroup(Group group) {
                return false;
            }

            @Override
            public boolean isInRole(Role role) {
                return false;
            }

            @Override
            public void removeGroup(Group group) {

            }

            @Override
            public void removeGroups() {

            }

            @Override
            public void removeRole(Role role) {

            }

            @Override
            public void removeRoles() {

            }
        };
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
