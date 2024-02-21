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
public class UpdateRoomRequest {

    @NotNull
    @NotBlank
    private Long roomId;

    @NotNull
    @NotBlank
    @Size(min = 3,max = 5)
    private String roomType;
}
