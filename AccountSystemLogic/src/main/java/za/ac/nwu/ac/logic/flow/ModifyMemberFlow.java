package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MemberDto;

import java.time.LocalDate;

public interface ModifyMemberFlow {

    MemberDto deleteMemberByMemberID(Long memberID);

    MemberDto updateMemberByMemberID(String memberNewName, String memberEmail, Long memberID);
}
