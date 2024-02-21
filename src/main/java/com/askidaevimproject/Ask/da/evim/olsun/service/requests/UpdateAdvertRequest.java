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
public class UpdateAdvertRequest {


    @NotNull
    @NotBlank
    private Long advertId;

    @NotNull
    @NotBlank
    private Long memberId;


    @NotBlank
    @NotNull
    @Size(min = 6)
    private String advertTitle;

    @NotNull
    @NotBlank
    private Long cityId;

    @NotNull
    @NotBlank
    private Long districtId;

    @NotNull
    @NotBlank
    private Long neighborhoodId;

    @NotNull
    @NotBlank
    private Long fuelId;

    @NotNull
    @NotBlank
    private Long roomId;

    @NotNull
    @NotBlank
    private String description;

    @NotNull
    @NotBlank
    private String ageOfDwelling;

    @NotNull
    @NotBlank
    private String meterSquare;








}
