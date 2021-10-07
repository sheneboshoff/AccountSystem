package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.logic.flow.ModifyAccountTransactionFlow;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class ModifyAccountTransactionFlowImpl implements ModifyAccountTransactionFlow {

    private final AccountTransactionTranslator accountTransactionTranslator;
    private final MemberTranslator member;

    @Autowired
    public ModifyAccountTransactionFlowImpl(AccountTransactionTranslator accountTransactionTranslator, MemberTranslator member){
        this.accountTransactionTranslator = accountTransactionTranslator;
        this.member = member;
    }

    @Override
    public AccountTransactionDto updateAccountTransaction() {
        return null;
    }

    @Override
    public AccountTransactionDto updateAccountTransaction(Long amount, LocalDate transactionDate) {
        return null;
    }

    /*@Override
    @Transactional
    public AccountTransactionDto addCurrency(Integer amount, Long memberID, Long accountID, LocalDate transactionDate) {
        try {
            Integer newBalance = 0;
            Integer oldBalance = 0;
            oldBalance = member.getMemberByMemberID(memberID).getAccountAmount();
            newBalance = oldBalance + amount;
            if (newBalance >= 0) {
                AccountTransaction accountTransaction = new AccountTransaction(amount, memberID, accountID);
                accountTransactionTranslator.updateTransaction(amount, memberID, accountID);
            }
        }
        //return accountTransactionTranslator.addCurrency(amount, memberID, accountID, transactionDate);
    }

    @Override
    public AccountTransactionDto subtractCurrency(Integer amount, Long memberID, Long accountID, LocalDate transactionDate) {
        return accountTransactionTranslator.subtractCurrency(amount, memberID, accountID, transactionDate);
    }*/
}
