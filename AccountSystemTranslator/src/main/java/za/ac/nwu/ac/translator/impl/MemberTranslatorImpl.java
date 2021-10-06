package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.repo.persistence.MemberRepository;
import za.ac.nwu.ac.translator.MemberTranslator;

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
    public MemberDto getMemberByMemberID(Long memberID) {
        try {
            Member member = memberRepository.getMemberByMemberID(memberID);
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

    @Override
    public MemberDto deleteMemberByMemberID(Long memberID) {
        try {
            Member member = memberRepository.getMemberByMemberID(memberID);
            memberRepository.deleteMemberByMemberID(memberID);
            return new MemberDto(member);
        } catch (Exception e) {
            throw new RuntimeException("Unable to update the database", e);
        }
    }

    @Override
    public MemberDto updateMemberByMemberID(String newMemberName, String newMemberEmail, Long memberID) {
        try {
            Member member = memberRepository.getMemberByMemberID(memberID);
            memberRepository.updateMemberByMemberID(newMemberName, newMemberEmail, memberID);
            return new MemberDto(member);
        } catch (Exception e) {
            throw new RuntimeException("Unable to update the database", e);
        }
    }
}
