package spring.online.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.online.auction.model.response.PhoneResponse;
import spring.online.auction.model.response.Message;
import spring.online.auction.service.WatchlistService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/auction/watchlist")
public class WatchlistController {
    @Autowired
    private WatchlistService watchlistService;

    @PostMapping("/user/{phoneId}")
    public Message addToWatchlist(@PathVariable Long phoneId, Principal principal){
        if(principal == null) return new Message("Please sign in");
        return watchlistService.addToWatchlist(phoneId,principal.getName());
    }
    @DeleteMapping("/user/{phoneId}")
    public Message removeFromWatchlist(@PathVariable Long phoneId, Principal principal){
        return watchlistService.removeFromWatchlist(phoneId,principal.getName());
    }
    @DeleteMapping("/admin/{phoneId}")
    public Void removeFromWatchlist(@PathVariable Long phoneId){
        return watchlistService.removeFromWatchlist(phoneId);
    }
    @GetMapping("/user")
    public List<PhoneResponse> getWatchItemsOfUser(Principal principal){
        return watchlistService.getWatchItemsOfUser(principal.getName());
    }
}
