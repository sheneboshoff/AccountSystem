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
    public MemberDto addCurrency(Integer amount, Long memberID, Long accountTypeID, LocalDate dateStarted) {
        try {
            int newBalance = 0;
            Integer oldBalance = 0;
            oldBalance = memberTranslator.getAccountAmountByMemberID(memberID);
            newBalance = oldBalance + amount;
            Member member = new Member(newBalance, memberID, accountTypeID);
            return memberTranslator.updateMemberAccountAmount(newBalance, memberID, accountTypeID, dateStarted);
        } catch (Exception e) {
            throw new RuntimeException("Unable to add currency amount to the member.", e);
        }
    }

    @Transactional
    @Override
    public MemberDto subtractCurrency(Integer amount, Long memberID, Long accountTypeID, LocalDate dateStarted) {
        try {
            Integer newBalance = 0;
            Integer oldBalance = 0;
            oldBalance = memberTranslator.getAccountAmountByMemberID(memberID);
            newBalance = oldBalance - amount;
            if (newBalance >= 0) {
                Member member = new Member(newBalance, memberID, accountTypeID);
                MemberDto result = memberTranslator.updateMemberAccountAmount(newBalance, memberID, accountTypeID, dateStarted);
                return result;
            }
            else {
                throw new RuntimeException("Unable to subtract amount, balance will be negative");
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to subtract currency amount from the member.", e);
        }
    }

}
