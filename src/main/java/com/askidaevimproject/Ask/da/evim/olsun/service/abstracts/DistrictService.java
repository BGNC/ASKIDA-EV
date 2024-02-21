package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;


import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateDistrictRequest;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateDistrictRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.DistrictsByCityIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllDistrictResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByDistrictIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByDistrictName;


import java.util.List;

public interface DistrictService {
    List<GetAllDistrictResponse> getAllDistrict();

    void addDistrict(CreateDistrictRequest createDistrictRequest);

    GetByDistrictName getByDistrictName(String district_name);

    void deleteDistrict(Long district_id);

    void updateDistrict(UpdateDistrictRequest updateDistrictRequest);

    GetByDistrictIdResponse getById(Long district_id);

    List<DistrictsByCityIdResponse> getDistrictsByCityId(Long cityId);
}
