package spring.online.auction.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="a_journal")
public class Journal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long phoneId;
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
    private String login;
    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime journalDate;

    public Journal() {
    }

    public Journal(Phone phone, String login) {
        this.phoneId = phone.getId();
        this.image = phone.getImage();
        this.description = phone.getDescription();
        this.brand = phone.getBrand();
        this.color = phone.getColor();
        this.opSystem = phone.getOpSystem();
        this.camResolution= phone.getCamResolution();
        this.screenSize = phone.getScreenSize();
        this.storageMemory = phone.getStorageMemory();
        this.startingPrice = phone.getStartingPrice();
        this.price = phone.getPrice();
        this.dateTimePosted = phone.getDateTimePosted();
        this.sellerLogin = phone.getSellerLogin();
        this.login = login;
        this.journalDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
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

    public Double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(Double startingPrice) {
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDateTime getJournalDate() {
        return journalDate;
    }

    public void setJournalDate(LocalDateTime journalDate) {
        this.journalDate = journalDate;
    }
}
