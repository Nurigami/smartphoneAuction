package spring.online.auction.service;

import org.springframework.web.multipart.MultipartFile;
import spring.online.auction.entity.Phone;
import spring.online.auction.model.response.Message;

import java.io.IOException;
import java.util.List;

public interface PhoneService {
    List<Phone> getAllPhones();
    List<Phone> getAllActivePhones();
    Phone getPhoneById(Long id);
    Message addPhone(Phone phone, String sellerLogin);
    Message updatePhone(Phone phone);
    Message deletePhoneById(Long id);
    List<Phone> getPhonesOfUser(String sellerLogin);
    Message imageUpload(MultipartFile file, Long id) throws IOException;
    Message deleteImage(Long id);
    List<Phone> searchPhones(Long brandId, Long colorId, Long memoryId, Long modelId,
                             Long osId, Long resolutionId, Long sizeId);
}
