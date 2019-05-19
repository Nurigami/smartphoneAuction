package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.online.auction.entity.Bid;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Long> {
    @Query("select b from Bid b " +
            "where b.phoneId = :id")
    List<Bid> getBidsByPhoneId(@Param("id") Long phoneId);

    @Query("select b.phoneId, count(b.phoneId) from Bid b " +
            "group by b.phoneId ")
    List<Object[]> getBidsCount();
}
