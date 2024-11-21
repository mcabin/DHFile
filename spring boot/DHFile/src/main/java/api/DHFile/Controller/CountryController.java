package api.DHFile.Controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.DHFile.Entities.Country;
import api.DHFile.Service.CountryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path = "country")
public class CountryController {
    private CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }
    
    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Country country){
        this.countryService.create(country);
    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping()
    public List<Country> getAll() {
        return this.countryService.searchAll();
    }
    
    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping(path="{id}")
    public Country getById(@RequestParam int id) {
        return this.countryService.searchByID(id);
    }
    
    @DeleteMapping(path="{id}")
    public void deleteById(@RequestParam int id){
        this.countryService.deleteById(id);
    }
}
