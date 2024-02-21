package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllAppliedHomesResponse {

    private Long advertId;
    private String ageOfDwelling;
    private String meterSquare;
    private String city;
    private String district;

}
