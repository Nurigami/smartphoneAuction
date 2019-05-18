package spring.online.auction.model;

public class PhoneModel {
    private Long phoneId;
    private String description;
    private Integer brand;
    private Integer color;
    private Integer opSystem;
    private Double camResolution;
    private Double screenSize;
    private Integer storageMemory;
    private Double initialPrice;

    public PhoneModel() {
    }

    public PhoneModel(String description, Integer brand, Integer color,
                      Integer opSystem, Double camResolution, Double screenSize,
                      Integer storageMemory, Double initialPrice) {
        this.description = description;
        this.brand = brand;
        this.color = color;
        this.opSystem = opSystem;
        this.camResolution = camResolution;
        this.screenSize = screenSize;
        this.storageMemory = storageMemory;
        this.initialPrice = initialPrice;
    }

    public PhoneModel(Long phoneId, String description, Integer brand, Integer color,
                      Integer opSystem, Double camResolution, Double screenSize,
                      Integer storageMemory, Double initialPrice) {
        this.phoneId = phoneId;
        this.description = description;
        this.brand = brand;
        this.color = color;
        this.opSystem = opSystem;
        this.camResolution = camResolution;
        this.screenSize = screenSize;
        this.storageMemory = storageMemory;
        this.initialPrice = initialPrice;
    }

    public Long getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBrand() {
        return brand;
    }

    public void setBrand(Integer brand) {
        this.brand = brand;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public Integer getOpSystem() {
        return opSystem;
    }

    public void setOpSystem(Integer opSystem) {
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
}
