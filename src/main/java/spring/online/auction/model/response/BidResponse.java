package spring.online.auction.model.response;

public class BidResponse {
    private Long count;

    public BidResponse() {
    }

    public BidResponse(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
