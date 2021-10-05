package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "SELECT " +
            "           at" +
            "       FROM " +
            "           AccountType at" +
            "       WHERE at.member_id = :member_id ")
    Member getMemberByMemberID(String memberID);
}
