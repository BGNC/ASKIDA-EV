package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByDistrictName {


    /*
    Example DATA :
    CityName:Ankara
    Ankara -> Mamak
    * **/
    private String cityName;
    private String districtName;


}
