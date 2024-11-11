package se.lexicon.marketplaceapi.repository;


import org.springframework.stereotype.Repository;
import se.lexicon.marketplaceapi.model.Advertisement;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AdvertisementRepository {
    List<Advertisement> findByExpirationDateAfter(LocalDate currentDate);
}
