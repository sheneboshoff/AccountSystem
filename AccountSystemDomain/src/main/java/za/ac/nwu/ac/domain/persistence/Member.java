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
    private Long accountAmount;
    private LocalDate dateJoined;
    private Set<AccountTransaction> accountTransactions;

    public Member(){}

    public Member(Long memberID, String memberName, String memberEmail, Long accountAmount, LocalDate dateJoined) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.accountAmount = accountAmount;
        this.dateJoined = dateJoined;
    }

    public Member(String memberName, String memberEmail, Long accountAmount, LocalDate dateJoined) {
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.accountAmount = accountAmount;
        this.dateJoined = dateJoined;
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
    public Long getAccountAmount() {
        return accountAmount;
    }

    public void setAccountAmount(Long accountAmount) {
        this.accountAmount = accountAmount;
    }

    @Column(name = "DATE_JOINED")
    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "member", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberID, member.memberID) && Objects.equals(memberName, member.memberName) && Objects.equals(memberEmail, member.memberEmail) && Objects.equals(accountAmount, member.accountAmount) && Objects.equals(dateJoined, member.dateJoined) && Objects.equals(accountTransactions, member.accountTransactions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberID, memberName, memberEmail, accountAmount, dateJoined, accountTransactions);
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID=" + memberID +
                ", memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", accountAmount=" + accountAmount +
                ", dateJoined=" + dateJoined +
                ", accountTransactions=" + accountTransactions +
                '}';
    }
}
