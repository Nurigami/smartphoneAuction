package spring.online.auction.model;

import spring.online.auction.entity.Bid;
import spring.online.auction.entity.Phone;
import spring.online.auction.model.response.BidResponse;
import spring.online.auction.model.response.TimeResponse;

public class Card {
    private Phone phone;
    private TimeResponse timeResponse;
    private BidResponse bidResponse;

    public Card() {
    }

    public Card(Phone phone, TimeResponse timeResponse, BidResponse bidResponse) {
        this.phone = phone;
        this.timeResponse = timeResponse;
        this.bidResponse = bidResponse;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public TimeResponse getTimeResponse() {
        return timeResponse;
    }

    public void setTimeResponse(TimeResponse timeResponse) {
        this.timeResponse = timeResponse;
    }

    public BidResponse getBidResponse() {
        return bidResponse;
    }

    public void setBidResponse(BidResponse bidResponse) {
        this.bidResponse = bidResponse;
    }

}
