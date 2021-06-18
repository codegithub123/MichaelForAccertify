package com.country.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@IdClass(StateId.class)
public class State {
    @Id
    @Column
    @NotNull(message = "Country Code cannot be null") 
    private String country_cd;
    @Column
    @NotNull(message = "State Name cannot be null")    
    private String state_name;
    @Id
    @Column
    @NotNull(message = "State Code cannot be null")     
    private String state_cd;
    @Column
    @Min(1)     
    private long state_population;
    
   
    public void setCountry_cd(String country_cd) {
        this.country_cd = country_cd;
        
    } 

    public String getCountry_cd() {
        return country_cd;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    } 

    public String getState_name() {
        return state_name;
    }

    public void setState_cd(String state_cd) {
        this.state_cd = state_cd;
        
    }

    public String getState_cd() {
        return state_cd;
    }

    public void setState_population(long state_population) {
        this.state_population = state_population;
    }

    public long getState_population() {
        return state_population;
    }


}
