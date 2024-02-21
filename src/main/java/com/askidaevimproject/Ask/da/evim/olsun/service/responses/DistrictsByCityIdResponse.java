package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.City;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.District;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistrictsByCityIdResponse {

    private String districtName;
    private Long districtId;


}
