package spring.online.auction.model.response;

public class CommentResponse {
    private Long count;

    public CommentResponse() {
    }

    public CommentResponse(Long count) {
        this.count = count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
