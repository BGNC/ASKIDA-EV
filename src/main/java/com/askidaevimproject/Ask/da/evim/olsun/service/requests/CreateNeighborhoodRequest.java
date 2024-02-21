package com.askidaevimproject.Ask.da.evim.olsun.service.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNeighborhoodRequest {

    @NotNull
    @NotBlank
    @Size(min = 5, max = 10)
    private String zipCode;

    @NotNull
    @NotBlank
    private Long districtId;

    @NotNull
    @NotBlank
    private String neighborhoodName;


}
