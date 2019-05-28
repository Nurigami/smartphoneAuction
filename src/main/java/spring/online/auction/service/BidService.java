package spring.online.auction.service;

import spring.online.auction.entity.Bid;
import spring.online.auction.model.request.BidRequest;
import spring.online.auction.model.response.BidResponse;
import spring.online.auction.model.response.Message;

import java.util.List;

public interface BidService {
    Message addBid(BidRequest bidRequest, String login);
    List<Bid> getBidsByPhoneId(Long phoneId);
    BidResponse getBidsCountByPhoneId(Long phoneId);
    Bid getWinnerBid(Long phoneId);
}
