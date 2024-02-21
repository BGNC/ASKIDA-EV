package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Fuel;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.FuelRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.FuelService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateFuelRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateFuelRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllFuelResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByFuelIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.rules.FuelBusinessRules;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FuelServiceImpl implements FuelService {

    private  FuelRepository fuelRepository;

    private ModelMapperService modelMapperService;

    private FuelBusinessRules fuelBusinessRules;

    public List<GetAllFuelResponse> getAllFuels(){

        List<Fuel> fuels = this.fuelRepository.findAll();
        List<GetAllFuelResponse> fuelResponses = new ArrayList<>();
        for(int i = 0; fuels.size() > i; i++) {
            GetAllFuelResponse getAllFuelResponse = new GetAllFuelResponse();
            getAllFuelResponse.setFuel_id(fuels.get(i).getFuelId());
            getAllFuelResponse.setFuelType(fuels.get(i).getFuelType());
            fuelResponses.add(getAllFuelResponse);
        }
        return fuelResponses;

        /* return fuels.
                stream()
                .map(fuel ->
                        this.modelMapperService.
                                forResponse().
                                map(fuel,GetAllFuelResponse.class)).toList();
         */

    }

    @Override
    public GetByFuelIdResponse getByFuelIdResponse(Long fuel_id){



        this.fuelBusinessRules.checkIfFuelIdExists(fuel_id);
        Fuel fuel = this.fuelRepository.findById(fuel_id).orElseThrow();
        return this.modelMapperService.forResponse().map(fuel,GetByFuelIdResponse.class);
    }

    @Override
    public void updateFuel(UpdateFuelRequest updateFuelRequest)
    {

        this.fuelBusinessRules.checkIfFuelTypeExists(updateFuelRequest.getFuel_type());

        Fuel fuel = this.modelMapperService.forResponse().map(updateFuelRequest,Fuel.class);
        this.fuelRepository.save(fuel);
    }
    @Override
    public void addFuel(CreateFuelRequest createFuelRequest) {

        this.fuelBusinessRules.checkIfFuelTypeExists(createFuelRequest.getFuelType());
        Fuel fuel = this.modelMapperService.forRequest().map(createFuelRequest,Fuel.class);
        this.fuelRepository.save(fuel);
    }

    public void deleteFuel(Long fuel_id) {

        if(this.fuelRepository.existsById(fuel_id)) this.fuelRepository.deleteById(fuel_id);
    }
}
