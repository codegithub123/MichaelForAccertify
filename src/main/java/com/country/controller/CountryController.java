package com.country.controller;

import com.country.model.CountryCurrency;
import com.country.model.CountryPopulation;
import com.country.model.State;

import com.country.service.CountryServiceImpl;
import java.util.HashMap;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CountryController 
{

@Autowired
CountryServiceImpl countryService;
    
@GetMapping("/CountryPopulation")
private HashMap<String,CountryPopulation> AllCountryPopulations() throws Exception {


    return countryService.getAllCountryPopulations();
}
@GetMapping("/CountryCurrency")
private HashMap<String,CountryCurrency> getAllCountryCurrencies() throws Exception {


    return countryService.getAllCountryCurrencies();
}

@GetMapping("/ValidateState")
private boolean validateState(@RequestParam(name="country_cd", required=true) String cnt_cd, 
                                @RequestParam(name="state_cd", required=true) String st_cd) throws Exception {


    return countryService.validateState(cnt_cd,st_cd);
}

@PutMapping("/AddState")
public void addState(@Valid @RequestBody State state) throws Exception {
         
  countryService.addState(state);
        
}



}
