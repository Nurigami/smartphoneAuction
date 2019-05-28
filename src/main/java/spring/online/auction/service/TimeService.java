package spring.online.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import spring.online.auction.entity.Phone;
import spring.online.auction.model.response.TimeResponse;
import spring.online.auction.repository.PhoneRepository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TimeService {
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private EmailService emailService;

    public TimeResponse getTimeLeftByPhoneId(Long phoneId){
        Phone phone = phoneService.getPhoneById(phoneId);
        if(phone!=null){
            Long diffMinutes = countTimeLeft(phone.getDateTimePosted());
            return new TimeResponse(sayTimeLeft(diffMinutes));
        }
        return null;
    }

    public String sayTimeLeft(Long diffMinutes){
        int days = (int) TimeUnit.MINUTES.toDays(diffMinutes);
        long hours = TimeUnit.MINUTES.toHours(diffMinutes) - (days *24);
        long minutes = TimeUnit.MINUTES.toMinutes(diffMinutes) - (TimeUnit.MINUTES.toHours(diffMinutes)* 60);
        return days+" days, "+hours+" hours, "+minutes+" minutes left";
    }

    public Long countTimeLeft(LocalDateTime dateTimePosted)
    {
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime endDateTime = dateTimePosted.plusDays(7);
        Long diffMinutes = nowDateTime.until(endDateTime, ChronoUnit.MINUTES);
        return diffMinutes;
    }


}
