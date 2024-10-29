package se.lexicon.marketplaceapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

@Entity
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String description;

    private String setTitle;

    @Future
    private LocalDate expirationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User createdBy;

    public void setCreatedBy(org.apache.catalina.User user) {
    }


    // Getters and Setters


    public @NotEmpty String getTitle() {
        return title;
    }

    public void setTitle(@NotEmpty String title) {
        this.title = title;
    }

    public @NotEmpty String getDescription() {
        return description;
    }

    public void setDescription(@NotEmpty String description) {
        this.description = description;
    }

    public String getSetTitle() {
        return setTitle;
    }

    public void setSetTitle(String setTitle) {
        this.setTitle = setTitle;
    }

    public @Future LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(@Future LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }
}
