package spring.online.auction.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "a_bid")
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime bidTime;
    private String login;
    private Double bidPrice;
    private Long phoneId;

    public Bid() {
    }

    public Bid(String login, Double bidPrice, Long phoneId) {
        this.bidTime = LocalDateTime.now();
        this.login = login;
        this.bidPrice = bidPrice;
        this.phoneId = phoneId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }
}
