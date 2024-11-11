package se.lexicon.marketplaceapi.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.marketplaceapi.dto.AdvertisementDTO;
import se.lexicon.marketplaceapi.model.Advertisement;
import se.lexicon.marketplaceapi.repository.AdvertisementRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdvertisementService {

    @Autowired
    private AdvertisementRepository advertisementRepository;

    public AdvertisementRepository createAdvertisement(AdvertisementDTO adDTO, User user) {

        return null;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisementRepository.findByExpirationDateAfter(LocalDate.now());
    }
}

