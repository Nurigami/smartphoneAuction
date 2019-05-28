package spring.online.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.online.auction.service.EmailService;

@RestController
@RequestMapping("/send/mail")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> sendEmail(@RequestHeader String subject, @RequestHeader String messageText, @RequestHeader String toEmail){
        emailService.sendEmail(subject,messageText,toEmail);
        return new ResponseEntity<>("Mail is sent", HttpStatus.OK);
    }
}
