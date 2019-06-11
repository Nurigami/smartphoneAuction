package spring.online.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import spring.online.auction.entity.Bid;
import spring.online.auction.entity.Phone;
import spring.online.auction.entity.User;
import spring.online.auction.repository.PhoneRepository;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private Environment environment;
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private BidService bidService;
    @Autowired
    private UserService userService;

    @Override
    public void sendEmail(String subject, String messageText, String toEmail) {
        final SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(subject);
        message.setText(messageText);
        message.setTo(toEmail);
        message.setFrom(environment.getProperty("spring.mail.username"));
        javaMailSender.send(message);
    }

    @Override
    public String getWinnerEmail(Long phoneId){
        Bid bid = bidService.getWinnerBid(phoneId);
        User user = userService.getUserById(bid.getUser().getId());
        String email = user.getEmail();
        return email;
    }

    @Override
    public String getSellerEmail(Long phoneId){
        Phone phone = phoneService.getPhoneById(phoneId);
        User user = userService.getUserByLogin(phone.getSellerLogin());
        String email = user.getEmail();
        return email;
    }

}