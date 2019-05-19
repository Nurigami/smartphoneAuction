package spring.online.auction.model;

public class BidResponse {
    private Long phoneId;
    private Long count;

    public BidResponse() {
    }

    public BidResponse(Long phoneId, Long count) {
        this.phoneId = phoneId;
        this.count = count;
    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
