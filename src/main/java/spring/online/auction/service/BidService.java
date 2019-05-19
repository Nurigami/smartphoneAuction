package spring.online.auction.service;

import spring.online.auction.entity.Bid;
import spring.online.auction.model.BidModel;
import spring.online.auction.model.BidResponse;
import spring.online.auction.model.Message;

import java.util.List;

public interface BidService {
    Message addBid(BidModel bidModel, String login);
    List<Bid> getBidsByPhoneId(Long phoneId);
    List<BidResponse> getBidsCount();
}
