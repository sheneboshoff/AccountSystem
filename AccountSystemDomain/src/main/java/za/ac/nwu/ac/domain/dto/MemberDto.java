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

    private Long memberID;
    private String memberName;
    private String memberEmail;
    private Integer accountAmount;
    private LocalDate dateJoined;
    private Long accountTypeID;

    public MemberDto(){}

    public MemberDto(Long memberID, String memberName, String memberEmail, Integer accountAmount, LocalDate dateJoined) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.accountAmount = accountAmount;
        this.dateJoined = dateJoined;
        this.memberID = memberID;
    }

    public MemberDto(Long memberID, String memberName, String memberEmail, Integer accountAmount, LocalDate dateJoined, Long accountTypeID) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.accountAmount = accountAmount;
        this.dateJoined = dateJoined;
        this.memberID = memberID;
        this.accountTypeID = accountTypeID;
    }

    public MemberDto(Member member) {
        //this.setMemberEmail(member.getMemberEmail());
        //this.setMemberName(member.getMemberName());
        this.setAccountAmount(member.getAccountAmount());
        //this.setDateJoined(member.getDateJoined());
        this.setMemberID(member.getMemberID());
        this.setAccountTypeID(member.getAccountTypeID());
    }

    @ApiModelProperty(position = 5,
        value = "Member ID",
        name = "MemberID",
        notes = "ID of member",
        dataType = "java.lang.Long",
        example = "1",
        required = true)
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
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
            example = "sheneboshoff6@gmail.com")
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
            example = "200")
    public Integer getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(Integer accountAmount) {
        this.accountAmount = accountAmount;
    }

    @ApiModelProperty(position = 4,
            value = "Member Date Joined",
            name = "DateJoined",
            notes = "Date that member joined",
            dataType = "java.lang.String",
            example = "2021-10-10")
    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    @ApiModelProperty(position = 6,
            value = "Account Type ID",
            name = "AccountTypeID",
            notes = "Unique ID that identifies the AccountType",
            dataType = "java.lang.Long",
            example = "1")
    public Long getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
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
        return new Member(getMemberName(), getMemberEmail(), getAccountAmount(), getDateJoined(), getAccountTypeID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, memberName, memberEmail, accountAmount, dateJoined, accountTypeID);
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "memberID=" + memberID +
                ", memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", accountAmount=" + accountAmount +
                ", dateJoined=" + dateJoined +
                ", accountTypeID=" + accountTypeID +
                '}';
    }
}
