package api.DHFile.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.DHFile.Entities.Country;
import api.DHFile.Repository.CountryRepository;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public void create(Country country){
        if(!this.countryRepository.existsByCountryName(country))
            this.countryRepository.save(country);
    }

    public Country searchByID(int id){
        return this.countryRepository.findById(id).orElse(null);
    }

    public Country searchByName(String name){
        return this.countryRepository.findByCountryName(name).orElse(null);
    }

    public List<Country> searchAll(){
        return this.countryRepository.findAll();
    }

    public void deleteById(int id){
        this.countryRepository.deleteById(id);
    }
}
