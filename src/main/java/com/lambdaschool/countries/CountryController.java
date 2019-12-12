package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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
    @GetMapping(value = "/names/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByFirstLetter(@PathVariable char letter) {
        ArrayList<Country> resList = CountriesApplication.clist.findCountries(CountryList.findByFirstLetter(letter));
        resList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return new ResponseEntity<>(resList, HttpStatus.OK);
    }

    // localhost:PORT/countries/names/size/{number}
    @GetMapping(value = "/names/size/{number}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesWithNameLongerThan(@PathVariable int number) {
        ArrayList<Country> resList = CountriesApplication.clist.findCountries(CountryList.findByNameLength(number));
        resList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));

        return new ResponseEntity<>(resList, HttpStatus.OK);
    }

    // localhost:PORT/countries/population/size/{people}
    @GetMapping(value = "/population/size/{people}")
    public ResponseEntity<?> getCountriesOfPopulationEqualToOrGreaterThan(@PathVariable int people) {
        ArrayList<Country> resList = CountriesApplication.clist.findCountries(CountryList.findByPopulation(people));

        return new ResponseEntity<>(resList, HttpStatus.OK);
    }

    // localhost:PORT/countries/population/min
    @GetMapping(value = "/population/min", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithMinPopulation() {
        CountriesApplication.clist.countryList.sort((c1, c2) -> (int) (c1.getPopulation() - c2.getPopulation()));

        return new ResponseEntity<>(CountriesApplication.clist.countryList.get(0), HttpStatus.OK);
    }

    // localhost:PORT/countries/population/max
    @GetMapping(value = "/population/max", produces = {"application/json"})
    public ResponseEntity<?> getCountryWithMaxPopulation() {
        CountriesApplication.clist.countryList.sort((c1, c2) -> (int) (c2.getPopulation() - c1.getPopulation()));

        return new ResponseEntity<>(CountriesApplication.clist.countryList.get(0), HttpStatus.OK);
    }

    // localhost:PORT/countries/population/min

    // localhost:PORT/countries/population/max

    // [STRETCH] localhost:PORT/countries/population/median

    // localhost:PORT/countries/age/min

    // localhost:PORT/countries/age/max

    // [STRETCH] localhost:PORT/countries/age/median

}
