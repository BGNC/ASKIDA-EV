package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetAdvertByIdResponse {
    private Long advertId;
    private String memberName;
    private String cityName;
    private String advertTitle;
    private String districtName;
    private String neighborhoodName;
    private String roomType;
    private String fuelType;
    private String description;
    private String ageOfDwelling;
    private String meterSquare;
    private String isActivate;
}
