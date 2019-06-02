package spring.online.auction.model.response;

public class WatchlistResponse {
    private Long count;

    public WatchlistResponse() {
    }

    public WatchlistResponse(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
