package com.askidaevimproject.Ask.da.evim.olsun.service.responses;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuthenticationResponse {


    private Long memberId;

    private String memberName;
    private Role role;

    private String memberSurname;
    private String memberMail;

    private String memberAddress;


    /**
     * After verify it activate will be changed.
     * When the user is registered is_Activate default 0
     * **/
    private int isActivate;


    /*
     * status 0 = > benefactor
     * status 1 => applicant
     * */

    private String status;

}
