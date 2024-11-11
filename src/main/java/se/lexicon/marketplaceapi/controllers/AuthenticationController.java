package se.lexicon.marketplaceapi.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.marketplaceapi.dto.UserDTO;
import se.lexicon.marketplaceapi.model.User;
import se.lexicon.marketplaceapi.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<SecurityProperties.User> loginUser(@RequestBody UserDTO userDTO) throws UserService.InvalidCredentialsException {
        User user = userService.authenticateUser(userDTO.getEmail(), userDTO.getPassword());
        ResponseEntity<SecurityProperties.User> ResponseEntity = null;
        return ResponseEntity;
    }
}
