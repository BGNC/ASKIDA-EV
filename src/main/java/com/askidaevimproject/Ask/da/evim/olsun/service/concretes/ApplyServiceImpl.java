package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;

import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Advert;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Apply;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Member;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.AdvertRepository;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.ApplyRepository;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.MemberRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.ApplyService;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class ApplyServiceImpl implements ApplyService {

    private ApplyRepository applyRepository;
    private ModelMapperService modelMapperService;
    private MemberRepository memberRepository;
    private AdvertRepository advertRepository;

    @Override
    public List<GetAllApplyResponse> getAllApply() {

        List<Apply> applyList = this.applyRepository.findAll();

        return applyList.stream().map(apply ->
                this.modelMapperService.forResponse().
                        map(apply,GetAllApplyResponse.class)).
                toList();
    }

    @Override
    public ResponseEntity<Object> applyForHome(Long memberId, Long advertId) {
        Advert advert = advertRepository.findById(advertId).orElseThrow();
        Member member = memberRepository.findById(memberId).orElseThrow();

        Apply applyChecked = applyRepository.findByMemberIdAndAdvertId(advertId,memberId);
        if(applyChecked != null) {
            return new ResponseEntity<>(new ApplyForHomeResponseEntity("AlreadyApplied",HttpStatus.NOT_FOUND),HttpStatus.OK);
        }

        Apply apply = new Apply().builder()
                .member(member)
                .advert(advert)
                .status(0)
                .build();
        applyRepository.save(apply);

        return new ResponseEntity<>(new ApplyForHomeResponseEntity("Successfully Applied",HttpStatus.OK),HttpStatus.OK);
    }

    @Override
    public List<GetAllAppliedHomesResponse> getAllAppliedHomes() {
        List<GetAllAppliedHomesResponse> appliedHomesResponses = new ArrayList<>();
        List<Long> applyIdList = applyRepository.getAdvertIds();
        List<Advert> appliedAdverts = new ArrayList<>();

        for(Long applyId: applyIdList) {
            Advert advert = advertRepository.findById(applyId).get();
            appliedAdverts.add(advert);
        }


        for(Advert advert : appliedAdverts) {
            GetAllAppliedHomesResponse getAllAppliedHomesResponse = new GetAllAppliedHomesResponse().builder()
                    .advertId(advert.getAdvertId())
                    .city(advert.getCity().getCityName())
                    .district(advert.getDistrict().getDistrictName())
                    .ageOfDwelling(advert.getAgeOfDwelling())
                    .meterSquare(advert.getMeterSquare())
                    .build();
            appliedHomesResponses.add(getAllAppliedHomesResponse);
        }
        return appliedHomesResponses;
    }

    @Override
    public List<GetAllMembersForHomesResponse> getAllMembersForHomes(Long advertId) {
        List<Apply> applyList = applyRepository.findByMemberId(advertId);
        List<GetAllMembersForHomesResponse> allMembersForHomesResponses = new ArrayList<>();
        for(Apply apply : applyList) {
            GetAllMembersForHomesResponse getAllMembersForHomesResponse = new GetAllMembersForHomesResponse().builder()
                    .memberId(apply.getMember().getMemberId())
                    .memberMail(apply.getMember().getMemberMail())
                    .memberName(apply.getMember().getMemberName())
                    .memberSurname(apply.getMember().getMemberSurname())
                    .memberPhone(apply.getMember().getMemberPhone())
                    .build();
            allMembersForHomesResponses.add(getAllMembersForHomesResponse);
        }

        return allMembersForHomesResponses;
    }

    @Override
    public ResponseEntity<Object> matchUserAndHome(Long memberId, Long advertId) {
        Apply apply = applyRepository.findByMemberIdAndAdvertId(advertId,memberId);
        if(apply != null) {
            apply.setStatus(1);
            applyRepository.save(apply);
            return new ResponseEntity<>(new BasicResponse(HttpStatus.OK,"Sucessfully"),HttpStatus.OK);
        }
        return new ResponseEntity<>(new BasicResponse(HttpStatus.NOT_ACCEPTABLE,"There is an problem in matchUserAndHome"),HttpStatus.OK);
    }


}
