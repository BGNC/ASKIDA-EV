package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByMemberNameResponse {

    private String memberName;
    private String memberSurname;
    private String memberPhone;
    private String memberMail;
}
