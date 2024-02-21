package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;


import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.CityNameFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.GettingInvalidCityByNameException;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.CityService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateCityRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateCityRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllCityResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByCityNameResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cities")
@CrossOrigin("https://askidaev-57ca6b6ed886.herokuapp.com")
//@CrossOrigin("http://localhost:3000")
public class CityController {

    private CityService cityService;


    @GetMapping("")
    List<GetAllCityResponse> getAllCity(){
        return cityService.getAllCity();
    }


    @PostMapping("")
    @ResponseStatus(CREATED)
    public void addCity(@RequestBody() @Valid() CreateCityRequest createCityRequest){

        this.cityService.addCity(createCityRequest);

    }

    //InvalidDataAccessApiUsageException

    @DeleteMapping("/{city_id}")
    public void deleteCity(@PathVariable Long city_id){
        cityService.deleteCityById(city_id);
    }

    @GetMapping("/cityName/{cityName}")
    public GetByCityNameResponse getByCityNameResponse(@PathVariable String cityName) throws GettingInvalidCityByNameException {


        return cityService.getByCityName(cityName);
    }

    @PutMapping("")
    public void updateCity(@RequestBody @Valid() UpdateCityRequest updateCityRequest){
        this.cityService.updateCity(updateCityRequest);
    }

}
