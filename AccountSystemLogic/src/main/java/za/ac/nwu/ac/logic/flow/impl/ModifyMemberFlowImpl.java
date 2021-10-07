package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.logic.flow.ModifyMemberFlow;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("modifyMemberFlowName")
public class ModifyMemberFlowImpl implements ModifyMemberFlow {

    private final MemberTranslator memberTranslator;

    @Autowired
    public ModifyMemberFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Transactional
    @Override
    public MemberDto addCurrency(Integer amount, Long memberID, Long accountTypeID) {
        try {
            Integer newBalance = 0;
            Integer oldBalance = 0;
            //oldBalance = memberTranslator.getMemberByMemberID(memberID, accountTypeID).getAccountAmount();
            oldBalance = memberTranslator.getAccountAmountByMemberID(memberID);
            newBalance = oldBalance + amount;
            Member member = new Member(newBalance, memberID, accountTypeID);
            MemberDto result = memberTranslator.updateMemberAccountAmount(newBalance, memberID, accountTypeID);
            return result; //memberTranslator.addCurrency(newBalance, memberID, accountTypeID);
        } catch (Exception e) {
            throw new RuntimeException("Unable to add currency amount to the member.", e);
        }
    }

}
