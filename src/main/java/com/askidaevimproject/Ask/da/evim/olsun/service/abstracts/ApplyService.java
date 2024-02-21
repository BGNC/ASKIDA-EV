package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllAppliedHomesResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllApplyResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllMembersForHomesResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ApplyService {

    List<GetAllApplyResponse> getAllApply();


    ResponseEntity<Object> applyForHome(Long memberId, Long advertId);

    List<GetAllAppliedHomesResponse> getAllAppliedHomes();

    List<GetAllMembersForHomesResponse> getAllMembersForHomes(Long advertId);

    ResponseEntity<Object> matchUserAndHome(Long memberId, Long advertId);
}
