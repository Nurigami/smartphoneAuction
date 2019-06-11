package spring.online.auction.entity;

import javax.persistence.*;

@Entity
@Table(name = "a_watchlist", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","phone_id"})})
public class Watchlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "phone_id")
    private Phone phone;

    public Watchlist() {
    }

    public Watchlist(User user, Phone phone) {
        this.user = user;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
