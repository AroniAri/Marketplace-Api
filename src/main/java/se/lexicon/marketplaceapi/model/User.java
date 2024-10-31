package se.lexicon.marketplaceapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.internal.engine.groups.Group;

import javax.management.relation.Role;
import java.util.Iterator;
import java.util.List;

@Entity
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Advertisement> advertisements;


    public abstract String getName();

    public abstract String getFullName();

    public abstract void setFullName(String s);

    public abstract Iterator<Group> getGroups();

    public abstract String getPassword();

    public abstract void setPassword(String s);

    public abstract Iterator<Role> getRoles();


    public void setUsername(String username) {
    }
}