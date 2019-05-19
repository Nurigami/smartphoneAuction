package spring.online.auction.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="a_phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String image;
    private String description;
    private String brand;
    private String color;
    private String opSystem;
    private Double camResolution;
    private Double screenSize;
    private Integer storageMemory;
    private Double startingPrice;
    private Double price;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateTimePosted;
    private String sellerLogin;

    public Phone() {
    }

    public Phone(String description, String brand, String color,
                 String opSystem, Double camResolution, Double screenSize, Integer storageMemory,
                 Double startingPrice, String sellerLogin) {
        this.description = description;
        this.brand = brand;
        this.color = color;
        this.opSystem = opSystem;
        this.camResolution = camResolution;
        this.screenSize = screenSize;
        this.storageMemory = storageMemory;
        this.startingPrice = startingPrice;
        this.price = startingPrice;
        this.dateTimePosted = LocalDateTime.now();
        this.sellerLogin = sellerLogin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        return startingPrice;
    }

    public void setInitialPrice(Double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
