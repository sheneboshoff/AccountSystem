package za.ac.nwu.ac.translator;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;

import java.util.List;

@Component
public interface AccountTransactionTranslator {
    List<AccountTransactionDto> getAllTransactions();

    AccountTransactionDto create(AccountTransactionDto accountTransaction);
}
