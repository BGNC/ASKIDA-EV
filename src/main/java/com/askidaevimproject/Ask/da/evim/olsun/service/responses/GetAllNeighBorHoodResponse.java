package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllNeighBorHoodResponse {

    private Long neighborhoodId;
    private String neighborhoodName;
    private String districtName;
    private String zipCode;


}
