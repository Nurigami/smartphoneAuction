package spring.online.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.online.auction.entity.Phone;
import spring.online.auction.model.response.TimeResponse;
import spring.online.auction.repository.PhoneRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TimeServiceImpl implements TimeService {
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private WatchlistService watchlistService;

    @Override
    public TimeResponse getTimeLeftByPhoneId(Long phoneId){
        Phone phone = phoneService.getPhoneById(phoneId);
        if(phone!=null){
            Long diffMinutes = countTimeLeft(phone.getDateTimePosted());
            return new TimeResponse(sayTimeLeft(diffMinutes));
        }
        return null;
    }

    @Override
    public String sayTimeLeft(Long diffMinutes){
        int days = (int) TimeUnit.MINUTES.toDays(diffMinutes);
        long hours = TimeUnit.MINUTES.toHours(diffMinutes) - (days *24);
        long minutes = TimeUnit.MINUTES.toMinutes(diffMinutes) - (TimeUnit.MINUTES.toHours(diffMinutes)* 60);
        return days+" days, "+hours+" hours, "+minutes+" minutes left";
    }

    @Override
    public Long countTimeLeft(LocalDateTime dateTimePosted)
    {
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime endDateTime = dateTimePosted.plusDays(7);
        Long diffMinutes = nowDateTime.until(endDateTime, ChronoUnit.MINUTES);
        return diffMinutes;
    }

    //@Scheduled(fixedRate = 60000)
    public void sendNotification() {
        List<Phone> phones = phoneService.getAllActivePhones();
        for(Phone phone : phones){
            Long diffMinutes = countTimeLeft(phone.getDateTimePosted());
            System.out.println(diffMinutes);
            if(diffMinutes < 1){
                handleAuctionEnd(phone);
            }
        }
    }

    public Void handleAuctionEnd(Phone phone){
        if(phone.getPrice()>phone.getStartingPrice()){
            phone.setStatus(false);
            phoneRepository.save(phone);
            watchlistService.removeFromWatchlist(phone.getId());
            emailService.sendEmail("Smartphone auction winner","xxx",emailService.getWinnerEmail(phone.getId()));
            emailService.sendEmail("Your smartphone was successfuly sold","xxx",emailService.getSellerEmail(phone.getId()));
        }
        phone.setDateTimePosted(LocalDateTime.now());
        phoneRepository.save(phone);
        emailService.sendEmail("No bid were placed for the phone, auction is automatically relisted for a week", "xxx",
                emailService.getSellerEmail(phone.getId()));
        return null;
    }

}
