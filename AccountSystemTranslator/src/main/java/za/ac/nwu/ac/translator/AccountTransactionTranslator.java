package za.ac.nwu.ac.translator;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.time.LocalDate;
import java.util.List;

@Component
public interface AccountTransactionTranslator {
    List<AccountTransactionDto> getAllTransactions();

    AccountTransactionDto create(AccountTransactionDto accountTransaction);

    /*AccountTransactionDto addCurrency(Integer amount, Long memberID, Long accountTypeID, LocalDate transactionDate);

    AccountTransactionDto subtractCurrency(Integer amount, Long memberID, Long accountTypeID, LocalDate transactionDate);*/

    AccountTransactionDto updateTransaction(Integer amount, Long memberID, Long accountTypeID);
}
