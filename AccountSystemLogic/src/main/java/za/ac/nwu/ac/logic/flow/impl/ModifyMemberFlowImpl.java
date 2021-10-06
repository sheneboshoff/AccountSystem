package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.flow.ModifyMemberFlow;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class ModifyMemberFlowImpl implements ModifyMemberFlow {

    private final MemberTranslator memberTranslator;

    @Autowired
    public ModifyMemberFlowImpl(MemberTranslator memberTranslator){
        this.memberTranslator = memberTranslator;
    }

    @Override
    public MemberDto deleteMemberByMemberID(Long memberID){
        return memberTranslator.deleteMemberByMemberID(memberID);
    }

    @Override
    public MemberDto updateMemberByMemberID(String memberNewName, String memberEmail, Long memberID){
        return memberTranslator.updateMemberByMemberID(memberNewName, memberEmail, memberID);
    }

}
