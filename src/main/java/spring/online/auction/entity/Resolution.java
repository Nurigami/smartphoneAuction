package spring.online.auction.entity;

import javax.persistence.*;

@Entity
@Table(name = "a_resolution")
public class Resolution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double value;

    public Resolution() {
    }

    public Resolution(Double value) {
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
