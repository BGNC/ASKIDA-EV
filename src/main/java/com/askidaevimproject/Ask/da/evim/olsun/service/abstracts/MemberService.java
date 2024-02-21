package com.askidaevimproject.Ask.da.evim.olsun.service.abstracts;

import com.askidaevimproject.Ask.da.evim.olsun.service.requests.CreateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.requests.UpdateMemberRequest;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetAllMemberResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberIdResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberMailResponse;
import com.askidaevimproject.Ask.da.evim.olsun.service.responses.GetByMemberNameResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberService {

    List<GetAllMemberResponse> getAllMembers();

    void registerMember(CreateMemberRequest createMemberRequest);

    void deleteMember(Long member_id);

    void updateMember(UpdateMemberRequest updateMemberRequest);



    GetByMemberIdResponse getByMemberId(Long member_id) ;

    GetByMemberMailResponse getByMemberMail(String member_mail);

    GetByMemberNameResponse getByMemberName(String member_name);

    ResponseEntity<?> confirmEmail(String confirmationToken);

    Integer getNumberOfMember();
}
