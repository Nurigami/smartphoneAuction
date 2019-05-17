package spring.online.auction.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="a_phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String photo;
    private String description;
    private String brand;
    private String color;
    private String opSystem;
    private Double camResolution;
    private Double screenSize;
    private Integer storageMemory;
    private Double initialPrice;
    private Double bidPrice;
    private LocalDateTime dateTimePosted;
    private String sellerLogin;

    public Phone() {
    }

    public Phone(String photo, String description, String brand, String color,
                 String opSystem, Double camResolution, Double screenSize, Integer storageMemory,
                 Double initialPrice, Double bidPrice, String sellerLogin) {
        this.photo = photo;
        this.description = description;
        this.brand = brand;
        this.color = color;
        this.opSystem = opSystem;
        this.camResolution = camResolution;
        this.screenSize = screenSize;
        this.storageMemory = storageMemory;
        this.initialPrice = initialPrice;
        this.bidPrice = bidPrice;
        this.dateTimePosted = LocalDateTime.now();
        this.sellerLogin = sellerLogin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOpSystem() {
        return opSystem;
    }

    public void setOpSystem(String opSystem) {
        this.opSystem = opSystem;
    }

    public Double getCamResolution() {
        return camResolution;
    }

    public void setCamResolution(Double camResolution) {
        this.camResolution = camResolution;
    }

    public Double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Double screenSize) {
        this.screenSize = screenSize;
    }

    public Integer getStorageMemory() {
        return storageMemory;
    }

    public void setStorageMemory(Integer storageMemory) {
        this.storageMemory = storageMemory;
    }

    public Double getInitialPrice() {
        return initialPrice;
    }

    public void setInitialPrice(Double initialPrice) {
        this.initialPrice = initialPrice;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public LocalDateTime getDateTimePosted() {
        return dateTimePosted;
    }

    public void setDateTimePosted(LocalDateTime dateTimePosted) {
        this.dateTimePosted = dateTimePosted;
    }

    public String getSellerLogin() {
        return sellerLogin;
    }

    public void setSellerLogin(String sellerLogin) {
        this.sellerLogin = sellerLogin;
    }
}
