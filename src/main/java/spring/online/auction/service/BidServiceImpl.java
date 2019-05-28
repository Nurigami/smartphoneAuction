package spring.online.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.online.auction.entity.Bid;
import spring.online.auction.entity.Phone;
import spring.online.auction.model.request.BidModel;
import spring.online.auction.model.response.BidResponse;
import spring.online.auction.model.Message;
import spring.online.auction.repository.BidRepository;
import spring.online.auction.repository.PhoneRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BidServiceImpl implements BidService {
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private BidRepository bidRepository;
    @Autowired
    private UserService userService;

    @Override
    public Message addBid(BidModel bidModel, String login) {
        Phone phone = phoneService.getPhoneById(bidModel.getPhoneId());
        if(bidModel.getBidPrice()<=phone.getPrice())return new Message("Please place bid more than " + phone.getPrice());
        phone.setPrice(bidModel.getBidPrice());
        phoneRepository.save(phone);
        Bid bid = new Bid();
        bid.setBidTime(LocalDateTime.now());
        bid.setUser(userService.getUserByLogin(login));
        bid.setBidPrice(bidModel.getBidPrice());
        bid.setPhoneId(bidModel.getPhoneId());
        bidRepository.save(bid);
        return new Message("Your bid is successfully placed");
    }

    @Override
    public List<Bid> getBidsByPhoneId(Long phoneId) {
        return bidRepository.getBidsByPhoneId(phoneId);
    }

    @Override
    public BidResponse getBidsCountByPhoneId(Long phoneId) {
        Long count = bidRepository.getBidsCountByPhoneId(phoneId);
        BidResponse bidResponse = new BidResponse(count);
        return bidResponse;
    }

    @Override
    public Bid getWinnerBid(Long phoneId) {
        return bidRepository.getWinnerBid(phoneId);
    }
}
