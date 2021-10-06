package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;

import java.time.LocalDate;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT " +
            "           ACCOUNT_TYPE_ID," +
            "           ACCOUNT_TYPE_NAME," +
            "           CREATION_DATE," +
            "           MNEMONIC" +
            "       FROM "+
            "           HR.ACCOUNT_TYPE " +
            "       WHERE MNEMONIC = :mnemonic ", nativeQuery = true)
    AccountType getAccountTypeByMnemonicNativeQuery(String mnemonic);

    @Query(value = "SELECT " +
            "           at" +
            "       FROM " +
            "           AccountType at" +
            "       WHERE at.mnemonic = :mnemonic ")
    AccountType getAccountTypeByMnemonic(String mnemonic);

    @Query(value = "SELECT new za.ac.nwu.ac.domain.dto.AccountTypeDto( " +
            "           at.mnemonic," +
            "           at.accountTypeName," +
            "           at.creationDate )" +
            "       FROM " +
            "           AccountType at" +
            "       WHERE at.mnemonic = :mnemonic ")
    AccountTypeDto getAccountTypeDtoByMnemonic(String mnemonic);

    @Modifying
    @Query(value = "DELETE FROM AccountType at WHERE at.mnemonic = :mnemonic")
    void deleteAccountTypeByMnemonic(String mnemonic);

    @Modifying
    @Query(value = "UPDATE AccountType at SET at.accountTypeName = :newAccountTypeName, "+
                "at.creationDate = :newCreationDate WHERE at.mnemonic = :mnemonic")
    void updateAccountTypeByMnemonic(String mnemonic, String newAccountTypeName, LocalDate newCreationDate);
}
