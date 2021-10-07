package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MemberDto;

import javax.transaction.Transactional;
import java.time.LocalDate;

public interface ModifyMemberFlow {

    @Transactional
    MemberDto addCurrency(Integer newAmount, Long memberID, Long accountTypeID);
}
