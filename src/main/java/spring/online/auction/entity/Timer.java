package spring.online.auction.entity;

public class Timer {
    private Long phoneId;
    private String timeLeft;

    public Timer() {
    }

    public Timer(Long phoneId, String timeLeft) {
        this.phoneId = phoneId;
        this.timeLeft = timeLeft;
    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

}
