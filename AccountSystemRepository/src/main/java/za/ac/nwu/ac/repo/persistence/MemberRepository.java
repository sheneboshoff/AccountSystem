package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Member;

import java.time.LocalDate;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Modifying
    @Query(value = "DELETE FROM Member m WHERE m.memberID = :memberID")
    void deleteMemberByMemberID(Long memberID);

    /*@Modifying
    @Query(value = "UPDATE Member m SET m.memberName = :newMemberName, "+
            "m.memberEmail = :newMemberEmail WHERE m.memberID = :memberID")
    void updateMemberByMemberID(Long memberID, String newMemberName, String newMemberEmail);*/

    @Modifying
    @Query(value = "UPDATE Member m SET m.memberName = :newMemberName, m.memberEmail = :newMemberEmail "+
                    "WHERE m.memberID = :memberID")
    void updateMemberByMemberID(String newMemberName, String newMemberEmail, Long memberID);

    @Query(value = "SELECT m FROM Member m WHERE m.memberID = :memberID AND m.accountTypeID = :accountTypeID")
    Member getMemberByMemberID(Long memberID, Long accountTypeID);

    @Modifying
    @Query(value = "UPDATE Member m SET m.accountAmount = :addCurrency WHERE m.memberID = :memberID AND m.accountTypeID = :accountTypeID")
    void updateMemberAccountAmount(@Param("addCurrency") Integer newAmount, @Param("memberID") Long memberID, @Param("accountTypeID") Long accountTypeID);

    @Query(value = "SELECT m.accountAmount FROM Member m WHERE m.memberID = :memberID")
    Integer getAccountAmountByMemberID(@Param("memberID") Long memberID);

}
