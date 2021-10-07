package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Member;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "A DTO that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {

    private static final long serialVersionUID = -259375539087796784L;

    private Integer amount;
    private LocalDate transactionDate;
    private AccountType accountType;
    private Member member;
    private Long accountTypeID;
    private Long memberID;

    public AccountTransactionDto() {
    }

    public AccountTransactionDto(Integer amount, LocalDate transactionDate, Long accountTypeID, Long memberID) {
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.accountTypeID = accountTypeID;
        this.memberID = memberID;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction, Long accountTypeID, Long memberID) {
        this.setAmount(accountTransaction.getAmount());
        this.setTransactionDate(accountTransaction.getTransactionDate());
        this.setAccountTypeID(accountType.getAccountTypeID());
        this.setMemberID(member.getMemberID());
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {
        this.setAmount(accountTransaction.getAmount());
        this.setTransactionDate(accountTransaction.getTransactionDate());
        this.setAccountTypeID(accountType.getAccountTypeID());
        this.setMemberID(member.getMemberID());
    }

    @ApiModelProperty(position = 1,
        value = "AccountTransaction Amount",
        name = "Amount",
        notes = "Displays the amount of the transaction",
        dataType = "java.lang.String",
        example = "200",
        required = false)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @ApiModelProperty(position = 2,
            value = "AccountTransaction TransactionDate",
            name = "TransactionDate",
            notes = "Displays the date the transaction was created",
            dataType = "java.lang.String",
            example = "2021-01-01")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @ApiModelProperty(position = 3,
        value = "AccountTypeID",
        name = "AccountTypeID",
        notes = "Displays the unique ID of the AccountType",
        dataType = "java.lang.Long",
        example = "1",
        required = true)
    public Long getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    @ApiModelProperty(position = 4,
            value = "MemberID",
            name = "MemberID",
            notes = "Displays the unique ID of the Member",
            dataType = "java.lang.Long",
            example = "1",
            required = true)
    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(amount, that.amount) && Objects.equals(transactionDate, that.transactionDate);
    }

    @JsonIgnore
    public AccountTransaction getAccountTransaction() {
        return new AccountTransaction(getAmount(), getTransactionDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, transactionDate);
    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "amount=" + amount +
                ", transactionDate=" + transactionDate +
                '}';
    }
}
