package spring.online.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import spring.online.auction.entity.Phone;
import spring.online.auction.entity.Timer;
import spring.online.auction.model.*;
import spring.online.auction.repository.PhoneRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class PhoneServiceImpl implements PhoneService {
    private static final String imageFolder = "D:\\Jv\\inClassProjects\\Sample Pictures\\";

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone getPhoneById(Long id) {
        return phoneRepository.findById(id).orElse(null);
    }

    @Override
    public Message addPhone(PhoneModel phoneModel, String sellerLogin) {
        Phone phone = new Phone();
        phone.setDescription(phoneModel.getDescription());
        phone.setBrand(Brand.valueOf(phoneModel.getBrand()).toString());
        phone.setColor(Color.valueOf(phoneModel.getColor()).toString());
        phone.setOpSystem(OpSystem.valueOf(phoneModel.getOpSystem()).toString());
        phone.setCamResolution(phoneModel.getCamResolution());
        phone.setScreenSize(phoneModel.getScreenSize());
        phone.setStorageMemory(phoneModel.getStorageMemory());
        phone.setInitialPrice(phoneModel.getInitialPrice());
        phone.setSellerLogin(sellerLogin);
        phone.setDateTimePosted(LocalDateTime.now());
        phoneRepository.save(phone);
        return new Message("Phone is successfully posted.");
    }

    @Override
    public Message updatePhone(PhoneModel phoneModel) {
        Phone phone = phoneRepository.findById(phoneModel.getPhoneId()).orElse(null);
        if(phone!=null){
            phone.setDescription(phoneModel.getDescription());
            phone.setBrand(Brand.valueOf(phoneModel.getBrand()).toString());
            phone.setColor(Color.valueOf(phoneModel.getColor()).toString());
            phone.setOpSystem(OpSystem.valueOf(phoneModel.getOpSystem()).toString());
            phone.setCamResolution(phoneModel.getCamResolution());
            phone.setScreenSize(phoneModel.getScreenSize());
            phone.setStorageMemory(phoneModel.getStorageMemory());
            phone.setInitialPrice(phoneModel.getInitialPrice());
            phoneRepository.save(phone);
            return new Message("Phone information is successfully updated.");
        }
        return new Message("Phone with id " + phoneModel.getPhoneId() + " does not exist");
    }

    @Override
    public Message deletePhoneById(Long id) {
        Phone phone = phoneRepository.findById(id).orElse(null);
        if(phone!=null){
            phoneRepository.delete(phone);
            return new Message("Phone is removed.");
        }
        return new Message("Phone with id " + id + " does not exist");
    }

    @Override
    public List<Phone> getPhonesOfUser(String ownerLogin) {
        return null;
    }

    @Override
    public Message imageUpload(MultipartFile file, Long id) throws IOException {
        String fileName = addImage(file);
        Phone phone = phoneRepository.findById(id).orElse(null);
        if(phone == null) return null;
        phone.setImage(fileName);
        phoneRepository.save(phone);
        return new Message("Image is uploaded");
    }

    @Override
    public Message deleteImage(Long id){
        Phone phone = phoneRepository.findById(id).orElse(null);
        if(phone == null) return null;
        Path filePath = Paths.get(imageFolder + phone.getImage());
        try {
            Files.delete(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        phone.setImage(null);
        phoneRepository.save(phone);
        return new Message("Image is removed");
    }

    private String addImage(MultipartFile file) throws IOException {
        byte[] bytes = file.getBytes();
        String modifiedFileName = System.currentTimeMillis() +
                file.getOriginalFilename().substring(file.getOriginalFilename().length() - 4);
        Path path = Paths.get(imageFolder + modifiedFileName);
        Files.write(path, bytes);
        return modifiedFileName;
    }

    @Override
    public List<Phone> searchPhones(String brand, String color, String opSystem) {
        return phoneRepository.searchPhones(brand,color,opSystem);
    }

    @Override
    public List<Timer> getTimeLeft(){
        List<Phone> phones = phoneRepository.findAll();
        List<Timer> timer = new ArrayList<>();
        for(Phone phone : phones){
            Long diffMinutes = countTimeLeft(phone.getDateTimePosted());
            if (diffMinutes > 1){
                timer.add(new Timer(phone.getId(), sayTimeLeft(diffMinutes)));
            } else {
                //перекинуть в журнал
                phoneRepository.delete(phone);
                //отправить сообщение
            }
        }
        return timer;
    }

    public static String sayTimeLeft(Long diffMinutes){
        int days = (int) TimeUnit.MINUTES.toDays(diffMinutes);
        long hours = TimeUnit.MINUTES.toHours(diffMinutes) - (days *24);
        long minutes = TimeUnit.MINUTES.toMinutes(diffMinutes) - (TimeUnit.MINUTES.toHours(diffMinutes)* 60);
        return days+" days, "+hours+" hours, "+minutes+" minutes left";
    }

    public static Long countTimeLeft(LocalDateTime dateTimePosted)
    {
        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime endDateTime = dateTimePosted.plusDays(7);
        Long diffMinutes = nowDateTime.until(endDateTime,ChronoUnit.MINUTES);
        return diffMinutes;
    }

    @Scheduled(fixedRate = 60000)
    public void scheduleTaskWithFixedRate() {
        //getTimeLeft();
    }

}
