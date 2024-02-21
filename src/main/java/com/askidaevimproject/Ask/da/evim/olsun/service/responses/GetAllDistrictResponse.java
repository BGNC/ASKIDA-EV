package com.askidaevimproject.Ask.da.evim.olsun.service.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllDistrictResponse {

    private Long districtId;

    private String cityName;
    private String districtName;

}
