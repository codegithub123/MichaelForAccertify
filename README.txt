1) I've used H2 database(in-memory db)
   a) You won't need to do any creation of tables or manual data load. It should all work automatically.
   b) Schema and data is in src../resources/data.sql or in war file ../WEB-INF/classes/data.sql
   c) To view the database go to URL: http://localhost:8080/country-operation-0.0.1-SNAPSHOT/h2-console

2) getAllCountryPopulations()
   //Apache Tomcat url
   http://localhost:8080/country-operation-0.0.1-SNAPSHOT/CountryPopulation

3) getAllCountryCurrencies()
   //Apache Tomcat url
   http://localhost:8080/country-operation-0.0.1-SNAPSHOT/CountryCurrency

4) validateState(country_code, state_code)
   //Sample Apache Tomcat 
   http://localhost:8080/country-operation-0.0.1-SNAPSHOT/ValidateState?country_cd=BLD&state_cd=LEF

5)  addState(country_cd, state_cd, state_name, state_population)
   //Apache Tomcat url
   http://localhost:8080/country-operation-0.0.1-SNAPSHOT/AddState
   
   Please note: You will need to open something like POSTMAN to create JSON request and call URL above with PUT
   
   //Sample JSON
   {  
       "country_cd": "BLD",  
       "state_name": "New State",  
       "state_cd": "ABC",
       "state_population": "100000" 
  }
  
6) Assumptions
   
   a) Since addState() method seems to be dealing with adding a state only, I assume that we are only adding states for countries that already exist
      So the program will not allow to add a state with the new country in this app.
   b) Also I assume that two different countries may have the same state code. I know that cities and states names sometimes exist in multiple countries.   
   
   


7) I'm sending a war file. You should be abble to simply deploy it to your Apache Tomcat and run the above URLs.
 



