package spring.online.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import spring.online.auction.entity.Bid;
import spring.online.auction.entity.Phone;
import spring.online.auction.entity.User;
import spring.online.auction.repository.PhoneRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Environment environment;
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private TimeService timeService;
    @Autowired
    private BidService bidService;
    @Autowired
    private UserService userService;
    @Autowired
    private PhoneRepository phoneRepository;

    public void sendEmail(String subject, String messageText, String toEmail) {

        final SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(subject);
        message.setText(messageText);
        message.setTo(toEmail);
        message.setFrom(environment.getProperty("spring.mail.username"));

        javaMailSender.send(message);
    }

    //@Scheduled(fixedRate = 60000)
    public void sendNotification() {
        List<Phone> phones = phoneService.getAllActivePhones();
        for(Phone phone : phones){
            Long diffMinutes = timeService.countTimeLeft(phone.getDateTimePosted());
            System.out.println(diffMinutes);
            if(diffMinutes < 10090){
                handleAuctionEnd(phone);
            }
        }
    }

    public Void handleAuctionEnd(Phone phone){

        if(phone.getPrice()>phone.getStartingPrice()){
            phone.setStatus(false);
            phoneRepository.save(phone);
            sendEmail("Smartphone auction winner","xxx",getWinnerEmail(phone.getId()));
            sendEmail("Your smartphone was successfuly sold","xxx",getSellerEmail(phone.getId()));
        }
        phone.setDateTimePosted(LocalDateTime.now());
        phoneRepository.save(phone);
        sendEmail("No bid were placed for the phone, auction is automatically relisted for a week", "xxx",
                getSellerEmail(phone.getId()));
        return null;
    }

    public String getWinnerEmail(Long phoneId){
        Bid bid = bidService.getWinnerBid(phoneId);
        User user = userService.getUserById(bid.getUser().getId());
        String email = user.getEmail();
        return email;
    }

    public String getSellerEmail(Long phoneId){
        Phone phone = phoneService.getPhoneById(phoneId);
        User user = userService.getUserByLogin(phone.getSellerLogin());
        String email = user.getEmail();
        return email;
    }

}