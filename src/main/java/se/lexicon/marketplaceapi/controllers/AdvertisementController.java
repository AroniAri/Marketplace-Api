package se.lexicon.marketplaceapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.marketplaceapi.dto.AdvertisementDTO;
import se.lexicon.marketplaceapi.model.Advertisement;
import se.lexicon.marketplaceapi.model.User;
import se.lexicon.marketplaceapi.service.AdvertisementService;
import se.lexicon.marketplaceapi.service.UserService;

import java.util.List;

@CrossOrigin(originPatterns ="http://localhost:3000")
@RestController
@RequestMapping("/api/ads")
public class AdvertisementController {

    @Autowired
    public AdvertisementService advertisementService;

    @Autowired
    public UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Advertisement> createAdvertisement(@RequestBody AdvertisementDTO adDTO, @RequestParam String email) throws UserService.InvalidCredentialsException {
        User user = userService.authenticateUser(email, adDTO.getPassword());
        Advertisement ad = (Advertisement) advertisementService.createAdvertisement(adDTO, (org.apache.catalina.User) user);
        return ResponseEntity.ok(ad);
    }

    @GetMapping
    public ResponseEntity<List<Advertisement>> getAdvertisements() {
        List<Advertisement> ads = advertisementService.getAdvertisements();
        return ResponseEntity.ok(ads);
    }
}