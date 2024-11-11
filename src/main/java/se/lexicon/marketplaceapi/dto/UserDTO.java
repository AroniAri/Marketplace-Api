package se.lexicon.marketplaceapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserDTO {
    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;


    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(@Email @NotEmpty String email) {
        this.email = email;
    }

    public void setPassword(@NotEmpty String password) {
        this.password = password;
    }

    public void setUsername(@NotEmpty String username) {
        this.username = username;
    }

    public void getName() {
        
    }
}