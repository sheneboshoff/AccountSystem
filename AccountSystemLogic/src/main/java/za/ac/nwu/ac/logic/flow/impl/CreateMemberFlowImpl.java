package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.flow.CreateMemberFlow;
import za.ac.nwu.ac.translator.MemberTranslator;
import za.ac.nwu.ac.translator.impl.MemberTranslatorImpl;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component("createMemberFlowName")
public class CreateMemberFlowImpl implements CreateMemberFlow {

    private final MemberTranslator memberTranslator;

    public CreateMemberFlowImpl(MemberTranslator memberTranslator){
        this.memberTranslator = memberTranslator;
    }

    @Override
    public MemberDto create(MemberDto member) {
        if (null == member.getDateJoined()) {
            member.setDateJoined(LocalDate.now());
        }
        return memberTranslator.create(member);
    }
}
