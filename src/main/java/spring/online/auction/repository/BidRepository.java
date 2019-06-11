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

    @Query("select count(b.phoneId) from Bid b " +
            "where b.phoneId = :id ")
    Long getBidsCountByPhoneId(@Param("id") Long phoneId);

    @Query("select b from Bid b " +
            "where b.phoneId = :id " +
            "and b.bidPrice = (select max(b.bidPrice) " +
            "from Bid b where b.phoneId = :id)")
    Bid getWinnerBid(@Param("id") Long phoneId);
}
