package spring.online.auction.entity;

import javax.persistence.*;

@Entity
@Table(name = "a_timer")
public class Timer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String timeLeft;
    @ManyToOne
    @JoinColumn(name = "phone_id")
    private Phone phone;

    public Timer() {
    }

    public Timer(String timeLeft, Phone phone) {
        this.timeLeft = timeLeft;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTimeLeft() {
        return timeLeft;
    }

    public void setTimeLeft(String timeLeft) {
        this.timeLeft = timeLeft;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
