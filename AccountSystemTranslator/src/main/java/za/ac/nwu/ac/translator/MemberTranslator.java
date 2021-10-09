package za.ac.nwu.ac.translator;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;

import java.time.LocalDate;
import java.util.List;

@Component
public interface MemberTranslator {
    List<MemberDto> getAllMembers();

    MemberDto create(MemberDto member);

    MemberDto updateMemberAccountAmount(Integer newAmount, Long memberID, Long accountTypeID, LocalDate dateStarted);

    MemberDto getMemberByMemberID(Long memberID, Long accountTypeID);

    Integer getAccountAmountByMemberID(Long memberID);

}
