package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.DistrictService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateDistrictRequest;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateDistrictRequest;

import com.askidaevimproject.Ask.da.evim.olsun.service.responses.DistrictsByCityIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllDistrictResponse;

import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByDistrictIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByDistrictName;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/districts")
@AllArgsConstructor
@CrossOrigin("https://askidaev-57ca6b6ed886.herokuapp.com")
//@CrossOrigin("http://localhost:3000")
public class DistrictController {

    private DistrictService districtService;


    @GetMapping("")
    public List<GetAllDistrictResponse> getAllDistrict(){

        return districtService.getAllDistrict();

    }


    @GetMapping("/city-id/{cityId}")
    public List<DistrictsByCityIdResponse> getDistrictsByCityId(@PathVariable("cityId") Long cityId) {
        return  districtService.getDistrictsByCityId(cityId);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDistrict(@RequestBody @Valid CreateDistrictRequest createDistrictRequest){
        districtService.addDistrict(createDistrictRequest);
    }

    @GetMapping("/findByDistrictName/{district_name}")
    public GetByDistrictName getByDistrictName(@PathVariable String district_name){
        return districtService.getByDistrictName(district_name);
    }
    @DeleteMapping("/{district_id}")
    public void deleteDistrict(@PathVariable Long district_id){
        districtService.deleteDistrict(district_id);
    }

    @PutMapping("")
    public void updateDistrict(@RequestBody @Valid UpdateDistrictRequest updateDistrictRequest){
        districtService.updateDistrict(updateDistrictRequest);
    }

    @GetMapping("/{district_id}")
    public GetByDistrictIdResponse getById(@PathVariable Long district_id){
        return this.districtService.getById(district_id);
    }





}
