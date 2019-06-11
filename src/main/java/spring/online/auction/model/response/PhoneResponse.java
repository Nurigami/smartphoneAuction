package spring.online.auction.model.response;

import spring.online.auction.entity.Phone;

public class PhoneResponse {
    private Phone phone;
    private TimeResponse timeResponse;
    private BidResponse bidResponse;
    private WatchlistResponse watchlistResponse;
    private CommentResponse commentResponse;

    public PhoneResponse() {
    }

    public PhoneResponse(Phone phone, TimeResponse timeResponse, BidResponse bidResponse, WatchlistResponse watchlistResponse, CommentResponse commentResponse) {
        this.phone = phone;
        this.timeResponse = timeResponse;
        this.bidResponse = bidResponse;
        this.watchlistResponse = watchlistResponse;
        this.commentResponse = commentResponse;
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

    public WatchlistResponse getWatchlistResponse() {
        return watchlistResponse;
    }

    public void setWatchlistResponse(WatchlistResponse watchlistResponse) {
        this.watchlistResponse = watchlistResponse;
    }

    public CommentResponse getCommentResponse() {
        return commentResponse;
    }

    public void setCommentResponse(CommentResponse commentResponse) {
        this.commentResponse = commentResponse;
    }
}
