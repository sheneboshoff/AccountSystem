package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.logic.flow.ModifyAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class ModifyAccountTransactionFlowImpl implements ModifyAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;

    @Autowired
    public ModifyAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator){
        this.accountTransactionTranslator = accountTransactionTranslator;
    }

    @Override
    public AccountTransactionDto updateAccountTransaction() {
        return null;
    }

    @Override
    public AccountTransactionDto updateAccountTransaction(Long amount, LocalDate transactionDate) {
        return null;
    }
}
