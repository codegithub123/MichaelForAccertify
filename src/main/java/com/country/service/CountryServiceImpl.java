package com.country.service;


import com.country.model.CountryCurrency;
import com.country.model.CountryPopulation;


import com.country.model.State;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class CountryServiceImpl implements CountryService {
        
    EntityManagerFactory emf;
    
    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
              this.emf = emf; 
    }
    
    @Override
    public HashMap<String,CountryPopulation> getAllCountryPopulations() throws Exception {
        
        HashMap<String, CountryPopulation> map = new HashMap<>();
        EntityManager entityManager = emf.createEntityManager();
        
        try {
             
           List<CountryPopulation> cp = entityManager.createNativeQuery("SELECT  c.country_name, s.country_cd, " +
               "sum(s.state_population) country_population FROM STATE s, country c " + 
                "where c.country_cd = s.country_cd group by s.country_cd",CountryPopulation.class).getResultList();
           
    
           for(CountryPopulation itr: cp) {
               map.put(itr.getCountry_cd(), itr);
            
           }
        }catch(Exception e) {
            System.out.println("Error in CountryServiceImpl.getAllCountryPopulations()" + e);
        }finally{
           try{
              entityManager.close();
           }catch(Exception e){
               System.out.println("Error in CountryServiceImpl.getAllCountryPopulations() closing EntityManager" + e);
           }
        }  
        
        return map;
        
    }
    
    @Override
    public HashMap<String,CountryCurrency> getAllCountryCurrencies() throws Exception {
        
        HashMap<String, CountryCurrency> map = new HashMap<>();
        EntityManager entityManager = emf.createEntityManager();    
        
        try {
                      
           List<CountryCurrency> cc = entityManager.createNativeQuery("SELECT  country_name, country_cd, " +
               "currency_cd FROM country "  
              ,CountryCurrency.class).getResultList();
           
    
           for(CountryCurrency itr: cc) {
               map.put(itr.getCountry_cd(), itr);
            
           }
        }catch(Exception e) {
            System.out.println("Error in CountryServiceImpl.getAllCountryCurrencies()" + e);
        }finally{
           try{
              entityManager.close();
           }catch(Exception e){
               System.out.println("Error in CountryServiceImpl.getAllCountryCurrencies() closing EntityManager" + e);
           }
        } 
                              
        
        return map;
        
    }
    
    @Override
    public boolean validateState(String cnt_cd,String st_cd) throws Exception {
        
        int count = 0;
        EntityManager entityManager = emf.createEntityManager();
            
        try {
                  
           Query query = entityManager.createNativeQuery("SELECT count(*) FROM state where country_cd = :cnt_cd and state_cd = :st_cd"  
           );
           query.setParameter("cnt_cd", cnt_cd.toUpperCase());
           query.setParameter("st_cd", st_cd.toUpperCase());
        
           count = ((Number) query.getSingleResult()).intValue();
        }
        catch(Exception e) {
            System.out.println("Error in CountryServiceImpl.validateState()" + e);
        }finally{
           try{
              entityManager.close();
           }catch(Exception e){
               System.out.println("Error in CountryServiceImpl.validateState() closing EntityManager" + e);
           }
        } 
        
       
        return (count > 0);
        
        
    }
    @Override
    public boolean validateCountry(String cnt_cd) throws Exception {
        
        int count = 0;
        EntityManager entityManager = emf.createEntityManager();
        
        try {
              
           Query query = entityManager.createNativeQuery("SELECT count(*) FROM country where country_cd = :cnt_cd"  
           );
           query.setParameter("cnt_cd", cnt_cd.toUpperCase());
                  
           count = ((Number) query.getSingleResult()).intValue();
        }
        catch(Exception e) {
            System.out.println("Error in CountryServiceImpl.validateCountry()" + e);
        }finally{
           try{
              entityManager.close();
           }catch(Exception e){
               System.out.println("Error in CountryServiceImpl.validateCountry() closing EntityManager" + e);
           }
        }
        
       
        return (count > 0);
        
        
    }
    
    @Override
    public void addState(State state) throws Exception {
        if(validateState(state.getCountry_cd(),state.getState_cd())) { 
            throw new Exception("Error: Country and State already exist!"); 
        }
        else if(!validateCountry(state.getCountry_cd())) { 
            throw new Exception("Error: Country doesn't exist!"); 
        }
        
        EntityManager entityManager = emf.createEntityManager();
        
        try {
                            
           entityManager.getTransaction().begin();
        
           state.setCountry_cd(state.getCountry_cd().toUpperCase());
           state.setState_cd(state.getState_cd().toUpperCase());
        
           entityManager.persist(state);
        
           entityManager.getTransaction().commit();
        }
        catch(Exception e) {
            System.out.println("Error in CountryServiceImpl.addState()" + e);
        }finally{
           try{
              entityManager.close();
           }catch(Exception e){
               System.out.println("Error in CountryServiceImpl.addState() closing EntityManager" + e);
           }
        }
        
        
        
    }
    
}
