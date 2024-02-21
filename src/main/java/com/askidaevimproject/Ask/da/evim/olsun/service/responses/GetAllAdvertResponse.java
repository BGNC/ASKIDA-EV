package com.askidaevimproject.Ask.da.evim.olsun.service.responses;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllAdvertResponse {

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

