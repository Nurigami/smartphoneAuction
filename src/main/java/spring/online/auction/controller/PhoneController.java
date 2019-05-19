package spring.online.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.online.auction.entity.Phone;
import spring.online.auction.entity.Timer;
import spring.online.auction.model.Message;
import spring.online.auction.model.PhoneModel;
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
    public ResponseEntity<Message> addPhone(@RequestBody PhoneModel phoneModel, Principal principal){
        return new ResponseEntity<>(phoneService.addPhone(phoneModel, principal.getName()), HttpStatus.OK);
    }

    @PutMapping("/user")
    public ResponseEntity<Message> updatePhone(@RequestBody PhoneModel phoneModel){
        return new ResponseEntity<>(phoneService.updatePhone(phoneModel),HttpStatus.OK);
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
    public List<Phone> searchPhones(@PathParam("brand") String brand, @PathParam("color") String color, @PathParam("opSystem") String opSystem){
        return phoneService.searchPhones(brand,color,opSystem);
    }

    @GetMapping("/all/time")
    public List<Timer> getTimeLeft(){
        return phoneService.getTimeLeft();
    }
}
