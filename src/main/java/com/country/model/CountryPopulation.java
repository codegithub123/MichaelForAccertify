package com.country.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
public class CountryPopulation
{ 
    @Id
    @Column
    @JsonIgnore    
    private String country_cd;
    @Column
    private String country_name;
    @Column
    private long country_population;

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getCountry_name() {
        return country_name;
    }

   
    public void setCountry_cd(String country_cd) {
        this.country_cd = country_cd;
    }

    public String getCountry_cd() {
        return country_cd;
    }

    public void setCountry_population(long country_population) {
        this.country_population = country_population;
    }

    public long getCountry_population() {
        return country_population;
    }


}
