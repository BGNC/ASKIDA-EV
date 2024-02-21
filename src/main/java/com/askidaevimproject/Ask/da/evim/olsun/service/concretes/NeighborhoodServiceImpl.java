package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Neighborhood;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.DistrictRepository;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.NeighborhoodRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.NeighborhoodService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateNeighborhoodRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateNeighborhoodRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllNeighBorHoodResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByNeighborHoodZipCodeResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByNeighborhoodIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByNeighborhoodName;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class NeighborhoodServiceImpl implements NeighborhoodService {

    private NeighborhoodRepository neighborhoodRepository;
    private ModelMapperService modelMapperService;

    private DistrictRepository districtRepository;

    @Override
    public List<GetAllNeighBorHoodResponse> getAllNeighBorHood() {
        List<Neighborhood> neighborhoods = this.neighborhoodRepository.findAll();
        List<GetAllNeighBorHoodResponse> responseList = new ArrayList<>();
        for (int i = 0; neighborhoods.size() > i; i++) {
            GetAllNeighBorHoodResponse getAllNeighBorHoodResponse = new GetAllNeighBorHoodResponse();
            Neighborhood neighborhood = neighborhoods.get(i);
            getAllNeighBorHoodResponse.setNeighborhoodId(neighborhood.getNeighborhoodId());
            getAllNeighBorHoodResponse.setNeighborhoodName(neighborhood.getNeighborhoodName());
            getAllNeighBorHoodResponse.setZipCode(neighborhood.getZipCode());
            getAllNeighBorHoodResponse.setDistrictName(neighborhood.getDistrict().getDistrictName());
            responseList.add(getAllNeighBorHoodResponse);
        }
        return responseList;
        // Add districtName into response. DistrictName returns null.
        /*
        return neighborhoods.
                stream().
                map
                        (neighborhood
                                ->
                                this.modelMapperService.forResponse().
                                        map(neighborhood,GetAllNeighBorHoodResponse.class)).toList();

         */
    }

    @Override
    public GetByNeighborHoodZipCodeResponse getByZipcode(String zip_code) {

        Neighborhood neighborhood = this.neighborhoodRepository.findByZipCode(zip_code);

        return this.modelMapperService.forResponse().map(neighborhood,GetByNeighborHoodZipCodeResponse.class);

    }

    @Override
    public void addNeighborhood(CreateNeighborhoodRequest createNeighborhoodRequest) {
        // Mapper ile yeni bir kayıt yapmak istediğimde aynı foregin key e sahip olan diğer datanın üstüne yazıyor.
        Neighborhood neighborhood = this.modelMapperService.forRequest().map(createNeighborhoodRequest,Neighborhood.class);
        Neighborhood neighborhood1 = new Neighborhood();
        neighborhood1.setNeighborhoodName(createNeighborhoodRequest.getNeighborhoodName());
        neighborhood1.setDistrict(districtRepository.getById(createNeighborhoodRequest.getDistrictId()));
        neighborhood1.setZipCode(createNeighborhoodRequest.getZipCode());
        this.neighborhoodRepository.save(neighborhood1);
    }

    @Override
    public void updateNeighborhood(UpdateNeighborhoodRequest updateNeighborhoodRequest) {
        Neighborhood neighborhood = this.modelMapperService.forRequest().map(updateNeighborhoodRequest,Neighborhood.class);
        this.neighborhoodRepository.save(neighborhood);
    }

    @Override
    public GetByNeighborhoodName getByNeighborhoodName(String neighborhood_name) {
        Neighborhood neighborhood = this.neighborhoodRepository.findByNeighborhoodName(neighborhood_name);

        return this.modelMapperService.forResponse().map(neighborhood,GetByNeighborhoodName.class);

    }

    @Override
    public GetByNeighborhoodIdResponse getById(Long neighborhood_id) {
        Neighborhood neighborhood = this.neighborhoodRepository.findById(neighborhood_id).orElseThrow();
        return this.modelMapperService.forResponse().map(neighborhood,GetByNeighborhoodIdResponse.class);
    }


}
