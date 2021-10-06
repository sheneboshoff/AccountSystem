package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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

    @Query(value = "SELECT m FROM Member m WHERE m.memberID = :memberID")
    Member getMemberByMemberID(Long memberID);

}
