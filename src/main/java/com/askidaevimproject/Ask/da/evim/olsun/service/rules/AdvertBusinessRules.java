package com.askidaevimproject.Ask.da.evim.olsun.service.rules;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Advert;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Member;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.AdvertRepository;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.MemberRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AdvertBusinessRules {

    private AdvertRepository advertRepository;

    private MemberRepository memberRepository;



    public boolean checkPointBeforeUserAddAdvert(Advert advert){

        Member member = advert.getMember();
        int isActivate = getMemberIsActivate(member.getMemberId());
        int memberStatus = Integer.parseInt(getMemberStatus(member.getMemberId()));
        /*
        Member is activate means member is activate equals to 0
        member status = 0 benefactor , 1 applicant
        * */
        if(isActivate!=1 && memberStatus == 0)
            return true;
        else
            return false;

    }


    private int getMemberIsActivate(Long member_id){
        return this.memberRepository.findById(member_id).get().getIsActivate();
    }

    private String  getMemberStatus(Long member_id){
        return this.memberRepository.findById(member_id).get().getStatus();
    }


}
