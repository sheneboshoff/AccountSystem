package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.time.LocalDate;
import java.util.List;

public interface ModifyAccountTypeFlow {

    AccountTypeDto deleteAccountType(String mnemonic);

    AccountTypeDto updateAccountType();

    AccountTypeDto updateAccountType(String anyString, String anyString1, LocalDate any);

    //add deleteAccountType
    //add updateAccountType
}
