package spring.online.auction.model.request;

public class BidRequest {
    private Long phoneId;
    private Double bidPrice;

    public BidRequest() {
    }

    public BidRequest(Long phoneId, Double bidPrice) {
        this.phoneId = phoneId;
        this.bidPrice = bidPrice;
    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }
}
