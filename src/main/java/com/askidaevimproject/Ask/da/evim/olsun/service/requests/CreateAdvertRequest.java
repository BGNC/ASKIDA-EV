package com.askidaevimproject.Ask.da.evim.olsun.service.requests;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdvertRequest {


    @NotNull
    @NotBlank
    @Size(min = 6)
    private String advertTitle;


    @NotNull
    @NotBlank
    private Long memberId;
    @NotBlank
    @NotNull
    private Long cityId;

    @NotBlank
    @NotNull
    private Long districtId;

    @NotBlank
    @NotNull
    private String neighborhoodName;

    @NotBlank
    @NotNull
    private Long fuelId;

    @NotBlank
    @NotNull
    private Long roomId;


    @NotBlank
    @NotNull
    @Size(min = 5)
    private String description;

    @NotBlank
    @NotNull
    @Size(min = 2)
    private String ageOfDwelling;

    @NotBlank
    @NotNull
    @Size(min = 2)
    private String meterSquare;


/*
    @NotBlank
    @NotNull
    @Transient
    private List<String> photoWays;

 */
}
