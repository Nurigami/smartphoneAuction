package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.online.auction.entity.Watchlist;

import java.util.List;

public interface WatchlistRepository extends JpaRepository<Watchlist, Long> {
    @Query("select w from Watchlist w where w.phone.id = :phoneId ")
    List<Watchlist> getWatchItemsByPhone(@Param("phoneId") Long phoneId);

    @Query("select w from Watchlist w where w.phone.id = :phoneId " +
            "and w.user.id = :userId")
    Watchlist getWatchItem(@Param("phoneId") Long phoneId, @Param("userId") Long userId);

    @Query("select w from Watchlist w where w.user.id = :userId ")
    List<Watchlist> getWatchItemsOfUser(@Param("userId") Long userId);

    @Query("select count(w.phone.id) from Watchlist w " +
            "where w.phone.id = :id ")
    Long getWatchersCountByPhoneId(@Param("id") Long phoneId);
}
