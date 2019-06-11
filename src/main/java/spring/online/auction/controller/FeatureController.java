package spring.online.auction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.online.auction.entity.*;
import spring.online.auction.service.FeatureService;

import java.util.List;

@RestController
@RequestMapping("/auction/feature")
public class FeatureController {
    @Autowired
    private FeatureService featureService;

    @GetMapping("/brand")
    public List<Brand> getAllBrands(){
        return featureService.getAllBrands();
    }

    @GetMapping("/color")
    public List<Color> getAllColors(){
        return featureService.getAllColors();
    }

    @GetMapping("/memory")
    public List<Memory> getAllMemories(){
        return featureService.getAllMemories();
    }

    @GetMapping("/model")
    public List<Model> getAllModels(){
        return featureService.getAllModels();
    }

    @GetMapping("/os")
    public List<OS> getAllOSs(){
        return featureService.getAllOSs();
    }

    @GetMapping("/resolution")
    public List<Resolution> getAllResolutions(){
        return featureService.getAllResolutions();
    }

    @GetMapping("/size")
    public List<Size> getAllSize(){
        return featureService.getAllSize();
    }
}
