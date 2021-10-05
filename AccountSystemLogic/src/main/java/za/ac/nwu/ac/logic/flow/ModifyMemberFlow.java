package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MemberDto;

import java.time.LocalDate;

public interface ModifyMemberFlow {

    MemberDto deleteMember(Long memberID);

    MemberDto updateMember();

    MemberDto updateMember(String memberName, String memberEmail, Long accountAmount, LocalDate dateJoined);
}
