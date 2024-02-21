package com.askidaevimproject.Ask.da.evim.olsun.model.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="member")
@Builder
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long memberId;


    @Column(name="member_name")
    private String memberName;


    @Enumerated(EnumType.STRING)
    @Builder.Default
    @Column(nullable = false,name = "role")
    private Role role = Role.USER;


    @Column(name="member_surname")
    private String memberSurname;

    @Column(name="member_phone",unique = true)
    private String memberPhone;

    @Column(name="member_mail",unique = true)
    private String memberMail;


    @Column(name="member_password")
    private String memberPassword;



    @Column(name = "member_address")
    private String memberAddress;


    /**
     * After verify it activate will be changed.
     * When the user is registered is_Activate default 0
     * **/
    @Column(name="is_activate")
    private int isActivate;


    /*
    * status 0 = > benefactor
    * status 1 => applicant
    * */

    @Column(name="status")
    private String status;


}
