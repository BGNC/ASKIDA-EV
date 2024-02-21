package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllApplyResponse {

    private Long apply_id;
    private String memberName;
    private String memberSurname;
    private String memberPhone;

}
