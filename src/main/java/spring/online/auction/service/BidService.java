package spring.online.auction.service;

import spring.online.auction.entity.Bid;
import spring.online.auction.model.request.BidModel;
import spring.online.auction.model.response.BidResponse;
import spring.online.auction.model.Message;

import java.util.List;

public interface BidService {
    Message addBid(BidModel bidModel, String login);
    List<Bid> getBidsByPhoneId(Long phoneId);
    BidResponse getBidsCountByPhoneId(Long phoneId);
    Bid getWinnerBid(Long phoneId);
}
