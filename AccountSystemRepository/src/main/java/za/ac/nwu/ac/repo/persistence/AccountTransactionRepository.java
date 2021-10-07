package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

import java.time.LocalDate;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

    @Query("SELECT t FROM AccountTransaction t WHERE t.transactionID = :transactionID")
    AccountTransaction getAccountTransactionByID(Long transactionID);

    /*@Query()
    AccountTransaction addCurrency(Integer amount, Long memberID, Long accountTypeID, LocalDate transactionDate);

    @Query
    AccountTransaction subtractCurrency(Integer amount, Long memberID, Long accountTypeID, LocalDate transactionDate);*/
}
