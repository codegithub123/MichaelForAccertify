package com.country.service;


import com.country.model.CountryCurrency;
import com.country.model.CountryPopulation;

import com.country.model.State;
import java.util.HashMap;




public interface CountryService {
 
   HashMap<String,CountryPopulation> getAllCountryPopulations() throws Exception;
   HashMap<String,CountryCurrency> getAllCountryCurrencies() throws Exception;
   boolean validateState(String cnt_cd,String st_cd) throws Exception; 
   void addState(State state) throws Exception;
   boolean validateCountry(String cnt_cd) throws Exception;

}
