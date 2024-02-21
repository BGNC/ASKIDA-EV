package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.NeighborhoodService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateNeighborhoodRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateNeighborhoodRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllNeighBorHoodResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByNeighborHoodZipCodeResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByNeighborhoodIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByNeighborhoodName;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/neighborhoods")
@AllArgsConstructor
@CrossOrigin("https://askidaev-57ca6b6ed886.herokuapp.com")
//@CrossOrigin("http://localhost:3000")
public class NeighborhoodController {

    private NeighborhoodService neighborhoodService;

    @GetMapping("")
    public List<GetAllNeighBorHoodResponse> getAllNeighBorHood(){
        return neighborhoodService.getAllNeighBorHood();
    }

    // We don't need this but there is a semantic and logical mistake. Method should return List because
    // one zipcode has one more neighborhood.
    @GetMapping("/zip_code/{zip_code}")
    public GetByNeighborHoodZipCodeResponse getByZipcode(@PathVariable String zip_code){
        return neighborhoodService.getByZipcode(zip_code);

    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNeighborhood(@RequestBody @Valid CreateNeighborhoodRequest createNeighborhoodRequest){
        this.neighborhoodService.addNeighborhood(createNeighborhoodRequest);
    }


    @PutMapping("")
    public void updateNeighborhood(@RequestBody @Valid UpdateNeighborhoodRequest updateNeighborhoodRequest){
        this.neighborhoodService.updateNeighborhood(updateNeighborhoodRequest);
    }

    @GetMapping("/neighborhoodName/{neighborhood_name}")
    public GetByNeighborhoodName getByNeighborhoodName(@PathVariable String neighborhood_name){
        return this.neighborhoodService.getByNeighborhoodName(neighborhood_name);
    }

    @GetMapping("/neighborhoodId/{neighborhood_id}")
    public GetByNeighborhoodIdResponse getById(@PathVariable Long neighborhood_id){
        return this.neighborhoodService.getById(neighborhood_id);
    }







}
