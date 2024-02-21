package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.FuelIsNotFoundException;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateFuelRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateFuelRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllFuelResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByFuelIdResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelService {
    List<GetAllFuelResponse> getAllFuels();
    GetByFuelIdResponse getByFuelIdResponse(Long fuel_id) throws FuelIsNotFoundException;
    void updateFuel(UpdateFuelRequest updateFuelRequest);
    void addFuel(CreateFuelRequest createFuelRequest);
    void deleteFuel(Long fuel_id);


}
