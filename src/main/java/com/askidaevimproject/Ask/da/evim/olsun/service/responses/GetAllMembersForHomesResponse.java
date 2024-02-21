package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllMembersForHomesResponse {

    private Long memberId;
    private String memberName;
    private String memberSurname;
    private String memberMail;
    private String memberPhone;

}
