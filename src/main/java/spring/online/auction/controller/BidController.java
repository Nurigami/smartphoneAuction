package spring.online.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.online.auction.entity.Bid;
import spring.online.auction.model.request.BidModel;
import spring.online.auction.model.response.BidResponse;
import spring.online.auction.model.Message;
import spring.online.auction.service.BidService;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/auction/bid")
public class BidController {
    @Autowired
    private BidService bidService;

    @PostMapping("/user")
    public ResponseEntity<Message> addBid(@RequestBody BidModel bidModel, Principal principal){
        return new ResponseEntity<>(bidService.addBid(bidModel,principal.getName()), HttpStatus.OK);
    }

    @GetMapping("/user/list/{phoneId}")
    public ResponseEntity<List<Bid>> getBidsByPhoneId(@PathVariable Long phoneId){
        return new ResponseEntity<>(bidService.getBidsByPhoneId(phoneId),HttpStatus.OK);
    }

    @GetMapping("/user/{phoneId}")
    public ResponseEntity<BidResponse> getBidsCountByPhoneId(@PathVariable Long phoneId){
        return new ResponseEntity<>(bidService.getBidsCountByPhoneId(phoneId),HttpStatus.OK);
    }

    @GetMapping("/user/winner/{phoneId}")
    public Bid getWinnerBid(@PathVariable Long phoneId){
        return bidService.getWinnerBid(phoneId);
    }
}
