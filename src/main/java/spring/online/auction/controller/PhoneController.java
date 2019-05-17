package spring.online.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.online.auction.entity.Phone;
import spring.online.auction.model.Brand;
import spring.online.auction.model.Message;
import spring.online.auction.model.PhoneModel;
import spring.online.auction.repository.PhoneRepository;

@RestController
@RequestMapping("/auction/phone")
public class PhoneController {
    @Autowired
    private PhoneRepository phoneRepository;

    @PostMapping
    public ResponseEntity<Message> addPhone(@RequestBody PhoneModel phoneModel){
        Phone phone = new Phone();
        phoneRepository.save(phone);
        return new ResponseEntity<>(new Message("New phone is saved"), HttpStatus.OK);
    }
}
