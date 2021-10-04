package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;

import java.time.LocalDate;
import java.util.List;

public interface ModifyAccountTypeFlow {
    Object deleteAccountType(String anyString);

    Object updateAccountType();

    Object updateAccountType(String anyString, String anyString1, LocalDate any);

    //add deleteAccountType
    //add updateAccountType
}
