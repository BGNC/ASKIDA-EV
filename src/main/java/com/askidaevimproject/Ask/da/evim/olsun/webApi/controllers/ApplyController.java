package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.ApplyService;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllAppliedHomesResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllApplyResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllMembersForHomesResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/applies")
@CrossOrigin("https://askidaev-57ca6b6ed886.herokuapp.com")
//@CrossOrigin("http://localhost:3000")
public class ApplyController {


    private ApplyService applyService;


    @GetMapping("")
    public List<GetAllApplyResponse> getAllApply(){
        return applyService.getAllApply();
    }

    @PostMapping("/member-id/{memberId}/advert-id/{advertId}")
    public ResponseEntity<Object> applyForHome(@PathVariable("memberId") Long memberId, @PathVariable("advertId") Long advertId) {
        return applyService.applyForHome(memberId,advertId);
    }

    @GetMapping("/homes")
    public List<GetAllAppliedHomesResponse> getAllAppliedHomes() {
        return applyService.getAllAppliedHomes();
    }

    @GetMapping("/homes/advert/{advertId}")
    public List<GetAllMembersForHomesResponse> getAllMembersForHomes(@PathVariable("advertId") Long advertId) {
        return  applyService.getAllMembersForHomes(advertId);
    }

    @GetMapping("/member/{memberId}/advert/{advertId}")
    public ResponseEntity<Object> matchUserAndHome(@PathVariable("memberId") Long memberId,@PathVariable("advertId") Long advertId) {
        return applyService.matchUserAndHome(memberId,advertId);
    }

}
