package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Member;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@ApiModel(value = "Member", description = "A DTO that represents the Member Table")
public class MemberDto implements Serializable {

    private static final long serialVersionUID = -3675411777951570019L;

    private String memberName;
    private String memberEmail;
    private Long accountAmount;
    private LocalDate dateJoined;

    public MemberDto(){}

    public MemberDto(String memberName, String memberEmail, Long accountAmount, LocalDate dateJoined) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.accountAmount = accountAmount;
        this.dateJoined = dateJoined;
    }

    public MemberDto(Member member) {
        this.setMemberEmail(member.getMemberEmail());
        this.setMemberName(member.getMemberName());
        this.setAccountAmount(member.getAccountAmount());
        this.setDateJoined(member.getDateJoined());
    }

    @ApiModelProperty(position = 1,
        value = "Member Name",
        name = "MemberName",
        notes = "Name of member",
        dataType = "java.lang.String",
        example = "Shené Boshoff",
        required = true)
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @ApiModelProperty(position = 2,
            value = "Member Email",
            name = "MemberEmail",
            notes = "Email of member",
            dataType = "java.lang.String",
            example = "sheneboshoff6@gmail.com",
            required = false)
    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    @ApiModelProperty(position = 3,
            value = "Member Account Amount",
            name = "AccountAmount",
            notes = "Amount of currency",
            dataType = "java.lang.String",
            example = "200",
            required = false)
    public Long getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(Long accountAmount) {
        this.accountAmount = accountAmount;
    }

    @ApiModelProperty(position = 4,
            value = "Member Date Joined",
            name = "DateJoined",
            notes = "Date that member joined",
            dataType = "java.lang.String",
            example = "2021-10-10",
            required = false)
    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDto memberDto = (MemberDto) o;
        return Objects.equals(memberName, memberDto.memberName) && Objects.equals(memberEmail, memberDto.memberEmail) && Objects.equals(accountAmount, memberDto.accountAmount);
    }

    @JsonIgnore
    public Member getMember() {
        return new Member(getMemberName(), getMemberEmail(), getAccountAmount(), getDateJoined());
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberName, memberEmail, accountAmount);
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", accountAmount=" + accountAmount +
                '}';
    }
}
