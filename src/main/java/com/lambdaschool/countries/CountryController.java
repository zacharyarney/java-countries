package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {
    // localhost:PORT/countries/names/all
    @GetMapping(value = "/names/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries() {
        CountriesApplication.clist.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(CountriesApplication.clist.countryList, HttpStatus.OK);
    }
    // localhost:PORT/countries/names/start/{letter}
    // localhost:PORT/countries/names/size/{number}
    // localhost:PORT/countries/population/size/{people}
    // localhost:PORT/countries/population/min
    // localhost:PORT/countries/population/max
    // [STRETCH] localhost:PORT/countries/population/median
    // localhost:PORT/countries/age/min
    // localhost:PORT/countries/age/max
    // [STRETCH] localhost:PORT/countries/age/median
}
