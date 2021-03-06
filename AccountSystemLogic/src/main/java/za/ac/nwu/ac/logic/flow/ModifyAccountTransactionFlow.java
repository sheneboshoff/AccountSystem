package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.time.LocalDate;

public interface ModifyAccountTransactionFlow {
    AccountTransactionDto updateAccountTransaction();

    AccountTransactionDto updateAccountTransaction(Long amount, LocalDate transactionDate);

    /*AccountTransactionDto addCurrency(Integer amount, Long memberID, Long accountID, LocalDate transactionDate);

    AccountTransactionDto subtractCurrency(Integer amount, Long memberID, Long accountID, LocalDate transactionDate);*/
}
