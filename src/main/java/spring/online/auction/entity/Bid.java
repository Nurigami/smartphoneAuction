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
    private Double bidPrce;
    @ManyToOne
    @JoinColumn(name = "phone_id")
    private Phone phone;

    public Bid() {
    }

    public Bid(String login, Double bidPrce, Phone phone) {
        this.bidTime = LocalDateTime.now();
        this.login = login;
        this.bidPrce = bidPrce;
        this.phone = phone;
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

    public Double getBidPrce() {
        return bidPrce;
    }

    public void setBidPrce(Double bidPrce) {
        this.bidPrce = bidPrce;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
