package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "MEMBER", schema = "HR")
public class Member {

    private Long memberID;
    private String memberName;
    private String memberEmail;
    private Integer accountAmount;
    private LocalDate dateJoined;
    private Long accountTypeID;

    public Member(){}

    public Member(Long memberID, String memberName, String memberEmail, Integer accountAmount, LocalDate dateJoined, Long accountTypeID) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.accountAmount = accountAmount;
        this.dateJoined = dateJoined;
        this.accountTypeID = accountTypeID;
    }

    public Member(String memberName, String memberEmail, Integer accountAmount, LocalDate dateJoined, Long accountTypeID) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.accountAmount = accountAmount;
        this.dateJoined = dateJoined;
        this.accountTypeID = accountTypeID;
    }

    public Member(Integer accountAmount, Long memberID, Long accountTypeID) {
        this.accountAmount = accountAmount;
        this.memberID = memberID;
        this.accountTypeID = accountTypeID;
    }

    @Id
    @SequenceGenerator(name = "ACC_TX_SEQ", sequenceName = "HR.ACC_TX_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_TX_SEQ")
    @Column(name = "MEMBER_ID")
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @Column(name = "MEMBER_NAME")
    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }


    @Column(name = "MEMBER_EMAIL")
    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    @Column(name = "ACCOUNT_AMOUNT")
    public Integer getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(Integer accountAmount) {
        this.accountAmount = accountAmount;
    }

    @Column(name = "DATE_JOINED")
    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    /*@OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "member", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }*/

    @Column(name = "ACCOUNT_TYPE_ID")
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
        Member member = (Member) o;
        return Objects.equals(memberID, member.memberID) && Objects.equals(memberName, member.memberName) && Objects.equals(memberEmail, member.memberEmail) && Objects.equals(accountAmount, member.accountAmount) && Objects.equals(dateJoined, member.dateJoined)/* && Objects.equals(accountTransactions, member.accountTransactions)*/;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, memberName, memberEmail, accountAmount, dateJoined/*, accountTransactions*/);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID=" + memberID +
                ", memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", accountAmount=" + accountAmount +
                ", dateJoined=" + dateJoined/* +
                ", accountTransactions=" + accountTransactions*/ +
                '}';
    }
}
