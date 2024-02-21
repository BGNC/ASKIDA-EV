package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;
import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.FuelIsNotFoundException;

import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.FuelService;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateFuelRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateFuelRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllFuelResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByFuelIdResponse;
import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController()
@RequestMapping("/api/fuels")
@AllArgsConstructor
@CrossOrigin("https://askidaev-57ca6b6ed886.herokuapp.com")
//@CrossOrigin("http://localhost:3000")
public class FuelController {

    private FuelService fuelService;

    @GetMapping("")
    public List<GetAllFuelResponse> getAllFuels(){
        return fuelService.getAllFuels();

    }
    @GetMapping(value="/{fuel_id}")
    public GetByFuelIdResponse getByFuelIdResponse(@PathVariable Long fuel_id) throws FuelIsNotFoundException {
        return fuelService.getByFuelIdResponse(fuel_id);

    }
    @PostMapping("")
    @ResponseStatus(code=CREATED)
    public void addFuel(@RequestBody @Valid CreateFuelRequest createFuelRequest) {
        this.fuelService.addFuel(createFuelRequest);
    }

    @DeleteMapping(value="/delete/{fuel_id}")
    public void deleteFuel(@PathVariable Long fuel_id){
        fuelService.deleteFuel(fuel_id);
    }


    // This doesn't work.
    @PutMapping("")
    public void updateFuel(@RequestBody  @Valid UpdateFuelRequest updateFuelRequest){
        this.fuelService.updateFuel(updateFuelRequest);
    }

}
