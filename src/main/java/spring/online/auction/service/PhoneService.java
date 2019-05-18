package spring.online.auction.service;

import org.springframework.web.multipart.MultipartFile;
import spring.online.auction.entity.Phone;
import spring.online.auction.model.Message;
import spring.online.auction.model.PhoneModel;

import java.io.IOException;
import java.util.List;

public interface PhoneService {
    List<Phone> getAllPhones();
    Phone getPhoneById(Long id);
    Message addPhone(PhoneModel phoneModel, String sellerLogin);
    Message updatePhone(PhoneModel phoneModel);
    Message deletePhoneById(Long id);
    List<Phone> getPhonesOfUser(String sellerLogin);
    Message imageUpload(MultipartFile file, Long id) throws IOException;
    Message deleteImage(Long id);
}
