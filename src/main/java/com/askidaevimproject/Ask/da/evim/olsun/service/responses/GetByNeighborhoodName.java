package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByNeighborhoodName {


    private Long neighborhood_id;
    private String neighborhood_name;
    private String zip_code;


}
