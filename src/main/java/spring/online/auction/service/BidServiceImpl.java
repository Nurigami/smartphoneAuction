package spring.online.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.online.auction.entity.Bid;
import spring.online.auction.entity.Phone;
import spring.online.auction.model.BidModel;
import spring.online.auction.model.BidResponse;
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
    @Override
    public Message addBid(BidModel bidModel, String login) {
        Phone phone = phoneService.getPhoneById(bidModel.getPhoneId());
        if(bidModel.getBidPrice()<=phone.getPrice())return new Message("Please place bid more than " + phone.getPrice());
        phone.setPrice(bidModel.getBidPrice());
        phoneRepository.save(phone);
        Bid bid = new Bid();
        bid.setBidTime(LocalDateTime.now());
        bid.setLogin(login);
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
    public List<BidResponse> getBidsCount() {
        List<Object[]> objects = bidRepository.getBidsCount();
        List<BidResponse> bidResponses = new ArrayList<>();
        for(Object[] object : objects){
            bidResponses.add(new BidResponse((Long)object[0],(Long)object[1]));
        }
        return bidResponses;
    }
}
