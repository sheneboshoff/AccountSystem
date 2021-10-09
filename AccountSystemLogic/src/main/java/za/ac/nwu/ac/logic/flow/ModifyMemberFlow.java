package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;

import javax.transaction.Transactional;
import java.time.LocalDate;

public interface ModifyMemberFlow {

    @Transactional
    MemberDto addCurrency(Integer newAmount, Long memberID, Long accountTypeID, LocalDate dateStarted);

    @Transactional
    MemberDto subtractCurrency(Integer newAmount, Long memberID, Long accountTypeID, LocalDate dateStarted);
}
