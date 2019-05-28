package spring.online.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.online.auction.model.Card;
import spring.online.auction.service.CardService;

import java.util.List;

@RestController
@RequestMapping("/auction/card")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards(){
        return new ResponseEntity<>(cardService.getAllCards(), HttpStatus.OK);
    }
}
