package spring.online.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.online.auction.entity.Phone;
import spring.online.auction.model.Card;
import spring.online.auction.repository.PhoneRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private TimeService timeService;
    @Autowired
    private BidService bidService;

    @Override
    public List<Card> getAllCards() {
        List<Phone> phones = phoneService.getAllActivePhones();
        List<Card> cards = new ArrayList<>();
        for(Phone phone : phones){
            cards.add(new Card(phone,timeService.getTimeLeftByPhoneId(phone.getId()),bidService.getBidsCountByPhoneId(phone.getId())));
        }
        return cards;
    }
}
