package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;


import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateAdvertRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateAdvertRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAdvertByIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllAdvertResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByAdvertTitle;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdvertService {

    List<GetAllAdvertResponse> getAllAdvert();

    ResponseEntity<Object> addAdvert(CreateAdvertRequest createAdvertRequest);

    void deleteAdvert(Long advert_id);

    void updateAdvert(UpdateAdvertRequest updateAdvertRequest);

    GetByAdvertTitle getByAdvertTitle(String advert_title);


    GetAdvertByIdResponse getAdvertById(Long advertId);

    Integer getNumberOfAdvert();
}
