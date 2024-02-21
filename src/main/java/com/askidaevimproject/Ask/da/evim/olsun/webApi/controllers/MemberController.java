package com.askidaevimproject.Ask.da.evim.olsun.webApi.controllers;

import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.MemberService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllMemberResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberMailResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberNameResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/members")
@AllArgsConstructor
@CrossOrigin("https://askidaev-57ca6b6ed886.herokuapp.com")
//@CrossOrigin("http://localhost:3000")
public class MemberController {

    private MemberService memberService;


    @PostMapping(value = "/register")
    public void registerMember(@RequestBody @Valid CreateMemberRequest createMemberRequest) {

        memberService.registerMember(createMemberRequest);
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> confirmUserAccount(@RequestParam("token")String confirmationToken) {
        return memberService.confirmEmail(confirmationToken);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllMemberResponse> getAllMembers(){
        return memberService.getAllMembers();
    }



    @GetMapping(value = "/memberId/{member_id}")
    @ResponseStatus(HttpStatus.OK)
    public GetByMemberIdResponse getByMemberId(@PathVariable Long member_id) {

        return memberService.getByMemberId(member_id);

    }



    @GetMapping("/memberName/{member_name}")
    @ResponseStatus(HttpStatus.OK)
    public GetByMemberNameResponse getByMemberName(@PathVariable String member_name){

        return this.memberService.getByMemberName(member_name);
    }

    @GetMapping("/memberMail/{member_mail}")
    @ResponseStatus(HttpStatus.OK)
    public GetByMemberMailResponse getByMemberMail(@PathVariable String member_mail){
        return memberService.getByMemberMail(member_mail);
    }



    @DeleteMapping("/{member_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMember(@PathVariable Long member_id){
        memberService.deleteMember(member_id);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public void updateMember(@RequestBody @Valid UpdateMemberRequest  updateMemberRequest){
        memberService.updateMember(updateMemberRequest);
    }

    @GetMapping("/number-of-member")
    public Integer getNumberOfMember() {
        return  memberService.getNumberOfMember();
    }

}
