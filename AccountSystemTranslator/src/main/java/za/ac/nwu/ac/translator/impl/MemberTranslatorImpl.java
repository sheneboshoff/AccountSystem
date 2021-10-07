package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.repo.persistence.MemberRepository;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class MemberTranslatorImpl implements MemberTranslator {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberTranslatorImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<MemberDto> getAllMembers() {
        List<MemberDto> memberDtos = new ArrayList<>();
        try {
            for (Member member: memberRepository.findAll()) {
                memberDtos.add(new MemberDto(member));
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the database", e);
        }
        return memberDtos;
    }

    @Override
    public MemberDto getMemberByMemberID(Long memberID, Long accountTypeID) {
        try {
            Member member = memberRepository.getMemberByMemberID(memberID, accountTypeID);
            return new MemberDto(member);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the database.", e);
        }
    }

    @Override
    public MemberDto create(MemberDto memberDto) {
        try {
            Member member = memberRepository.save(memberDto.getMember());
            return new MemberDto(member);
        } catch (Exception e) {
            throw new RuntimeException("Unable to save to the database",e);
        }
    }

    @Transactional
    @Override
    public MemberDto updateMemberAccountAmount(Integer newAmount, Long memberID, Long accountTypeID) {
        try {
            Member member = new Member(newAmount, memberID, accountTypeID);
            memberRepository.updateMemberAccountAmount(newAmount, memberID, accountTypeID);
            return new MemberDto(member);
        } catch (Exception e) {
            throw new RuntimeException("Unable to update the database", e);
        }
    }

    @Override
    public Integer getAccountAmountByMemberID(Long memberID) {
        try {
            return memberRepository.getAccountAmountByMemberID(memberID);
        } catch (Exception e) {
            throw new RuntimeException("Unable to read from the database", e);
        }
    }
}
