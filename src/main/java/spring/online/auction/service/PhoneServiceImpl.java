package spring.online.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.online.auction.entity.Phone;
import spring.online.auction.model.response.Message;
import spring.online.auction.model.*;
import spring.online.auction.repository.PhoneRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

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
    public List<Phone> getAllActivePhones() {
        return phoneRepository.getAllActivePhones();
    }

    @Override
    public Phone getPhoneById(Long id) {
        return phoneRepository.findById(id).orElse(null);
    }

    @Override
    public Message addPhone(Phone phone, String sellerLogin) {
        phone.setSellerLogin(sellerLogin);
        phone.setDateTimePosted(LocalDateTime.now());
        phoneRepository.save(phone);
        return new Message("Phone is successfully posted.");
    }

    @Override
    public Message updatePhone(Phone phone) {
        Phone p = phoneRepository.findById(phone.getId()).orElse(null);
        if(p!=null){
            p.setTitle(phone.getTitle());
            p.setDescription(phone.getDescription());
            p.setBrand(phone.getBrand());
            p.setColor(phone.getColor());
            p.setMemory(phone.getMemory());
            p.setResolution(phone.getResolution());
            p.setOs(phone.getOs());
            p.setModel(phone.getModel());
            p.setSize(phone.getSize());
            phoneRepository.save(p);
            return new Message("Phone information is successfully updated.");
        }
        return new Message("Phone with id " + phone.getId() + " does not exist");
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
    public List<Phone> searchPhones(Long brandId) {
        return phoneRepository.searchPhones(brandId);
    }

}
