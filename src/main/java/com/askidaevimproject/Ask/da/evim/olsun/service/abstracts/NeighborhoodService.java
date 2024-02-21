package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateNeighborhoodRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateNeighborhoodRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllNeighBorHoodResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByNeighborHoodZipCodeResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByNeighborhoodIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByNeighborhoodName;

import java.util.List;

public interface NeighborhoodService {

    List<GetAllNeighBorHoodResponse> getAllNeighBorHood();

    GetByNeighborHoodZipCodeResponse getByZipcode(String zip_code);

    void addNeighborhood(CreateNeighborhoodRequest createNeighborhoodRequest);

    void updateNeighborhood(UpdateNeighborhoodRequest updateNeighborhoodRequest);

    GetByNeighborhoodName getByNeighborhoodName(String neighborhood_name);

    GetByNeighborhoodIdResponse getById(Long neighborhood_id);



}
