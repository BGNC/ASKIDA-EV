package com.askidaevimproject.Ask.da.evim.olsun.service.rules;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.CityNameFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CityBusinessRules {

    private CityRepository cityRepository;

    public void checkIfCityNameExists(String cityName) throws CityNameFoundException {
        if((this.cityRepository.existsByCityName(cityName))){
            throw new CityNameFoundException("The entered city is not added/updated because, it is  matched check entered city name ");
        }
    }







}
