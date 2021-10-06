package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.time.LocalDate;
import java.util.List;

public interface ModifyAccountTypeFlow {

    AccountTypeDto deleteAccountTypeByMnemonic(String mnemonic);

    AccountTypeDto updateAccountType(String anyString, String anyString1, LocalDate any);
}
