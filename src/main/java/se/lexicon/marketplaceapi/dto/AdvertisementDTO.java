package se.lexicon.marketplaceapi.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public class AdvertisementDTO {
    @NotEmpty
    private String title;
    @NotEmpty
    private String description;
    @Future
    private LocalDate expirationDate;
    @NotEmpty
    public Object getTitle;
    @NotEmpty
    public Object getDescription;
    @NotEmpty
    public Object getExpirationDate;
    @NotEmpty
    public String getPassword(){
        return null;
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

    public @Future LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(@Future LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public @NotEmpty Object getGetTitle() {
        return getTitle;
    }

    public void setGetTitle(@NotEmpty Object getTitle) {
        this.getTitle = getTitle;
    }

    public @NotEmpty Object getGetDescription() {
        return getDescription;
    }

    public void setGetDescription(@NotEmpty Object getDescription) {
        this.getDescription = getDescription;
    }

    public @NotEmpty Object getGetExpirationDate() {
        return getExpirationDate;
    }

    public void setGetExpirationDate(@NotEmpty Object getExpirationDate) {
        this.getExpirationDate = getExpirationDate;
    }


}