package spring.online.auction.service;

import spring.online.auction.entity.Watchlist;
import spring.online.auction.model.response.PhoneResponse;
import spring.online.auction.model.response.Message;
import spring.online.auction.model.response.WatchlistResponse;

import java.util.List;

public interface WatchlistService {
    Message addToWatchlist(Long phoneId, String login);
    Message removeFromWatchlist(Long phoneId, String login);
    Void removeFromWatchlist(Long phoneId);
    Watchlist getWatchItem(Long phoneId, String login);
    List<PhoneResponse> getWatchItemsOfUser(String login);
    WatchlistResponse getWatchersCountByPhoneId(Long phoneId);
}
