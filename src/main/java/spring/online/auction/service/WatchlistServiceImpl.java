package spring.online.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.online.auction.entity.Phone;
import spring.online.auction.entity.User;
import spring.online.auction.entity.Watchlist;
import spring.online.auction.model.response.Card;
import spring.online.auction.model.response.Message;
import spring.online.auction.model.response.WatchlistResponse;
import spring.online.auction.repository.WatchlistRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class WatchlistServiceImpl implements WatchlistService {
    @Autowired
    private WatchlistRepository watchlistRepository;
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private UserService userService;
    @Autowired
    private TimeService timeService;
    @Autowired
    private BidService bidService;
    @Autowired
    private WatchlistService watchlistService;
    @Autowired
    private CommentService commentService;

    @Override
    @Transactional
    public Message addToWatchlist(Long phoneId, String login) {
        User user = userService.getUserByLogin(login);
        Phone phone = phoneService.getPhoneById(phoneId);
        Watchlist watchlist = new Watchlist(user,phone);
        watchlistRepository.save(watchlist);
        return new Message("Item is added to your watchlist");
    }

    @Override
    @Transactional
    public Message removeFromWatchlist(Long phoneId, String login) {
        User user = userService.getUserByLogin(login);
        Watchlist watchlist = watchlistRepository.getWatchItem(phoneId,user.getId());
        watchlistRepository.delete(watchlist);
        return new Message("Item is removed from your watchlist");
    }

    @Override
    public Void removeFromWatchlist(Long phoneId) {
        List<Watchlist> watchlists = watchlistRepository.getWatchItemsByPhone(phoneId);
        for(Watchlist watchlist : watchlists){
            watchlistRepository.delete(watchlist);
        }
        return null;
    }

    @Override
    public Watchlist getWatchItem(Long phoneId, String login) {
        User user = userService.getUserByLogin(login);
        return watchlistRepository.getWatchItem(phoneId,user.getId());
    }

    @Override
    public List<Card> getWatchItemsOfUser(String login) {
        User user = userService.getUserByLogin(login);
        List<Watchlist> watchlists = watchlistRepository.getWatchItemsOfUser(user.getId());
        List<Card> cards = new ArrayList<>();
        for(Watchlist watchlist : watchlists){
            cards.add(new Card(watchlist.getPhone(),timeService.getTimeLeftByPhoneId(watchlist.getPhone().getId()),
                    bidService.getBidsCountByPhoneId(watchlist.getPhone().getId()),
                    watchlistService.getWatchersCountByPhoneId(watchlist.getPhone().getId()),
                    commentService.getCommentsCountByPhoneId(watchlist.getPhone().getId())));
        }
        return cards;
    }

    @Override
    public WatchlistResponse getWatchersCountByPhoneId(Long phoneId) {
        return new WatchlistResponse(watchlistRepository.getWatchersCountByPhoneId(phoneId));
    }
}
