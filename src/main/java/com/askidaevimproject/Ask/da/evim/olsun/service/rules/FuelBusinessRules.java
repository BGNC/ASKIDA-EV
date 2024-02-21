package com.askidaevimproject.Ask.da.evim.olsun.service.rules;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.FuelIdIsNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.FuelIsExistsException;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.FuelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FuelBusinessRules {

    private FuelRepository fuelRepository;


    public void checkIfFuelTypeExists(String fuelType){
        if(this.fuelRepository.existsByFuelType(fuelType)){
            throw new FuelIsExistsException("The fuel type is using in the database");
        }
    }

    public void checkIfFuelIdExists(Long fuel_id){
        if(!(this.fuelRepository.existsById(fuel_id))) {
            throw new FuelIdIsNotFoundException("No record was found for the id you entered.");
        }
    }



}
