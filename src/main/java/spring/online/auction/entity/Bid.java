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
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Double bidPrice;
    private Long phoneId;

    public Bid() {
    }

    public Bid(User user, Double bidPrice, Long phoneId) {
        this.bidTime = LocalDateTime.now();
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
