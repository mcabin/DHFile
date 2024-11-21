package api.DHFile.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import api.DHFile.Entities.Country;
import java.util.Optional;


public interface CountryRepository extends JpaRepository<Country,Integer>{
    Optional<Country> findByCountryName(String countryName);
    boolean existsByCountryName(Country country);
    
}
