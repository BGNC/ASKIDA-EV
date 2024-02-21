package com.askidaevimproject.Ask.da.evim.olsun.service.rules;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.exceptions.*;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Member;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.MemberRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MemberBusinessRules {

    private MemberRepository memberRepository;

    public void checkIfMemberMailExists(String mail) {

        if(this.memberRepository.existsByMemberMail(mail)){
            throw new MemberMailException("The mail address is already taken . ");
        }
    }

    public void checkIfMemberPhoneExists(String phone){
        if(this.memberRepository.existsByMemberPhone(phone))
            throw new MemberPhoneException("The phone number is using ");
    }
    public void checkIfMemberNameExists(String memberName){
        if(!(this.memberRepository.existsByMemberName(memberName))){
            throw new MemberNameNotFoundException("The member name is not matched any member please check entered member name ");
        }
    }

    public void checkIfMemberIdExists(Long member_id){
        if(!(this.memberRepository.existsById(member_id))){
            throw new MemberIdNotFoundException("The member ıd is not mathched any member please check the entered value ");
        }
    }

    public void checkMemberStatus(List<Member> memberList){

        for (Member member : memberList) {
            if (member.getStatus().equals("0"))
                member.setStatus("Applicant");
            else
                member.setStatus("Benefactor");
        }
    }











}
