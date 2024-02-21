package com.askidaevimproject.Ask.da.evim.olsun.service.concretes;
import com.askidaevimproject.Ask.da.evim.olsun.core.utilities.mappers.abstracts.ModelMapperService;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Member;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Role;
import com.askidaevimproject.Ask.da.evim.olsun.model.concretes.Verify;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.MemberRepository;
import com.askidaevimproject.Ask.da.evim.olsun.repository.abstracts.VerifyRepository;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.EmailService;
import com.askidaevimproject.Ask.da.evim.olsun.service.abstracts.MemberService;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateMemberRequest;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllMemberResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberMailResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberNameResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.rules.MemberBusinessRules;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private  MemberRepository memberRepository;
    private ModelMapperService modelMapperService;

    private EmailService emailService;
    private VerifyRepository verifyRepository;

    private MemberBusinessRules memberBusinessRules;


    @Override
    public List<GetAllMemberResponse> getAllMembers()
    {

        List<Member> members = this.memberRepository.findAll();
        this.memberBusinessRules.checkMemberStatus(members);

        return members.
                stream()
                .map(member ->
                        this.modelMapperService.
                                forResponse().
                                map(member,GetAllMemberResponse.class)).toList();
    }

    @Override
    public void registerMember(@NotNull CreateMemberRequest createMemberRequest) {

        this.memberBusinessRules.checkIfMemberMailExists(createMemberRequest.getMemberMail());
        this.memberBusinessRules.checkIfMemberPhoneExists(createMemberRequest.getMemberPhone());

        System.out.println(createMemberRequest.getMemberMail());

        Member member=this.modelMapperService.forRequest().map(createMemberRequest, Member.class);

        member.setIsActivate(0);
        member.setRole(Role.USER);

        this.memberRepository.save(member);


        Verify confirmationToken = new Verify(member);

        verifyRepository.save(confirmationToken);

        //System.out.println(member.getMemberMail());
        //System.out.println(createMemberRequest.getMemberMail());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("askindaev@gmail.com");
        mailMessage.setTo(createMemberRequest.getMemberMail());
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setText( "Hello " + member.getMemberName() +" " +member.getMemberSurname()
                + "\nTo confirm your account, please click here : "
                +"https://askidaevbackend-6593566faf1d.herokuapp.com/api/members/confirm-account?token="+confirmationToken.getConfirmationToken());
        emailService.sendEmail(mailMessage);


        // System.out.println("Confirmation Token: " + confirmationToken.getConfirmationToken());


    }


    public void deleteMember(Long member_id) {

        if(memberRepository.existsById(member_id))
        {
            memberRepository.deleteById(member_id);
        }
    }

    public void updateMember(UpdateMemberRequest updateMemberRequest) {

        this.memberBusinessRules.checkIfMemberMailExists(updateMemberRequest.getMemberMail());
        this.memberBusinessRules.checkIfMemberPhoneExists(updateMemberRequest.getMemberPhone());
        Member member = this.modelMapperService.forRequest().map(updateMemberRequest, Member.class);
        this.memberRepository.save(member);


    }

    @Override
    public GetByMemberIdResponse getByMemberId(Long member_id)  {


        this.memberBusinessRules.checkIfMemberIdExists(member_id);
        Member member = this.memberRepository.findById(member_id).orElseThrow();
        return this.modelMapperService.forResponse().map(member,GetByMemberIdResponse.class);
    }

    @Override
    public GetByMemberMailResponse getByMemberMail(String member_mail) {


        Member member = this.memberRepository.findByMemberMail(member_mail);
        return this.modelMapperService.forResponse().map(member,GetByMemberMailResponse.class);
    }

    @Override
    public GetByMemberNameResponse getByMemberName(String member_name) {
        this.memberBusinessRules.checkIfMemberNameExists(member_name);
        Member member = this.memberRepository.findByMemberName(member_name);
        return this.modelMapperService.forResponse().map(member,GetByMemberNameResponse.class);
    }

    @Override
    public ResponseEntity<?> confirmEmail(String confirmationToken) {


        Verify token = verifyRepository.findByConfirmationToken(confirmationToken);




        if(token != null)
        {
            /*
            * By matching the mail address in the member table with the member_id in the verify table,
            * it is the token belonging to that member and the is activate part of that member is converted from offline to online.
            *
            * */
            Member member = memberRepository.findByMemberMailIgnoreCase(token.getMember().getMemberMail());
            member.setIsActivate(1);
            memberRepository.save(member);
            return ResponseEntity.ok("Email verified successfully!");
        }
        return ResponseEntity.badRequest().body("Error: Couldn't verify email");
    }

    @Override
    public Integer getNumberOfMember() {
        return memberRepository.getNumberOfMember();
    }


}
