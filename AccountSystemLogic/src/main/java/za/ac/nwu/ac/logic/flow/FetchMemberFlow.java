package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MemberDto;

import java.util.List;

public interface FetchMemberFlow {
    List<MemberDto> getAllMembers();

    MemberDto getMemberByMemberID(Long memberID, Long accountTypeID);
}
