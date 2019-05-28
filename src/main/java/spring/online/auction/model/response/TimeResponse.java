package spring.online.auction.model.response;

public class TimeResponse {
    private String timeLeft;

    public TimeResponse() {
    }

    public TimeResponse(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

}
