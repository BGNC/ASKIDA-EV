package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByMemberMailResponse {

    private String memberName;
    private String memberSurname;
    private String memberPhone;
    private String memberMail;
    private String memberAddress;


}
