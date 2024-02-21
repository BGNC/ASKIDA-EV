package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Member;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.MemberRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.AuthService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UserAuthenticationRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.UserAuthenticationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.OptionalInt;

@Service
@AllArgsConstructor
public class AuthServiceImp implements AuthService {

    private MemberRepository memberRepository;

    @Override
    public ResponseEntity<UserAuthenticationResponse> authenticateUser(UserAuthenticationRequest userAuthenticationRequest) {

        boolean isValidEmail = memberRepository.existsByMemberMail(userAuthenticationRequest.getEmail()) ;
        if(!isValidEmail) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Member member = memberRepository.findByMemberMail(userAuthenticationRequest.getEmail());
        if(member.getMemberMail().equals(userAuthenticationRequest.getEmail())
                && member.getMemberPassword().equals(userAuthenticationRequest.getPassword())
                && member.getIsActivate() == 1
        ) {
            UserAuthenticationResponse userAuthenticationResponse = new UserAuthenticationResponse().builder()
                    .role(member.getRole())
                    .memberName(member.getMemberName())
                    .status(member.getStatus())
                    .memberAddress(member.getMemberAddress())
                    .memberSurname(member.getMemberSurname())
                    .memberAddress(member.getMemberAddress())
                    .memberId(member.getMemberId())
                    .memberMail(member.getMemberMail())
                    .isActivate(member.getIsActivate())
                    .build();
        return new ResponseEntity<>(userAuthenticationResponse,HttpStatus.OK);
        }
        if(member.getIsActivate() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
