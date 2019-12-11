package com.lambdaschool.countries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication {
    static CountryList clist;

    public static void main(String[] args) {
        clist = new CountryList();
        SpringApplication.run(CountriesApplication.class, args);
    }

}
