package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "accountTransaction", schema = "HR")
public class AccountTransaction implements Serializable {

    private static final long serialVersionUID = 5687286736050369260L;

    private Long transactionID;
    private Integer amount;
    private LocalDate transactionDate;
    private Long memberID;
    private Long accountTypeID;

    public AccountTransaction(Integer amount, LocalDate transactionDate) {
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction() {
    }

    public AccountTransaction(Long transactionID, Integer amount, LocalDate transactionDate) {
        this.transactionID = transactionID;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public AccountTransaction(Integer amount, Long memberID, Long accountTypeID) {
        this.amount = amount;
        this.memberID = memberID;
        this.accountTypeID = accountTypeID;
    }

    @Id
    @SequenceGenerator(name = "ACC_TX_SEQ", sequenceName = "HR.ACC_TX_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_TX_SEQ")

    @Column(name = "TRANSACTION_ID")
    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    @Column(name = "MEMBER_ID")
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @Column(name = "AMOUNT")
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Column(name = "TRANSACTION_DATE")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }
}
