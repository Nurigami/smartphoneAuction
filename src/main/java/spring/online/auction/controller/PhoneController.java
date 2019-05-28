package spring.online.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.online.auction.entity.Phone;
import spring.online.auction.model.response.Message;
import spring.online.auction.service.PhoneService;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/auction/phone")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping("/all")
    public ResponseEntity<List<Phone>> getAllPhones(){
        return new ResponseEntity<>(phoneService.getAllPhones(),HttpStatus.OK);
    }

    @GetMapping("/admin/{id}")
    public ResponseEntity<Phone> getPhoneById(@PathVariable Long id){
        return new ResponseEntity<>(phoneService.getPhoneById(id),HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<Message> addPhone(@RequestBody Phone phone, Principal principal){
        return new ResponseEntity<>(phoneService.addPhone(phone, principal.getName()), HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<Message> updatePhone(@RequestBody Phone phone){
        return new ResponseEntity<>(phoneService.updatePhone(phone),HttpStatus.OK);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Message> deletePhoneById(@PathVariable Long id){
        return new ResponseEntity<>(phoneService.deletePhoneById(id),HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Phone>> getPhonesOfUser(Principal principal){
        return new ResponseEntity<>(phoneService.getPhonesOfUser(principal.getName()),HttpStatus.OK);
    }

    @PostMapping("/user/image/{id}")
    public ResponseEntity<Message> imageUpload(@RequestParam("file") MultipartFile file, @PathVariable Long id) throws IOException {
        return new ResponseEntity<>(phoneService.imageUpload(file,id),HttpStatus.OK);
    }

    @DeleteMapping("/user/image/{id}")
    public ResponseEntity<Message> deleteImage(@PathVariable Long id){
        return new ResponseEntity<>(phoneService.deleteImage(id),HttpStatus.OK);
    }

    @GetMapping("/all/search")
    public List<Phone> searchPhones(@RequestParam("brand") Long brandId){
        return phoneService.searchPhones(brandId);
    }

}
