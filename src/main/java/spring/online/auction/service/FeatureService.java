package spring.online.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.online.auction.entity.*;
import spring.online.auction.repository.*;

import java.util.List;

@Service
public class FeatureService {
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private MemoryRepository memoryRepository;
    @Autowired
    private ModelRepository modelRepository;
    @Autowired
    private OSRepository osRepository;
    @Autowired
    private ResolutionRepository resolutionRepository;
    @Autowired
    private SizeRepository sizeRepository;

    public List<Brand> getAllBrands(){
        return brandRepository.findAll();
    }

    public List<Color> getAllColors(){
        return colorRepository.findAll();
    }

    public List<Memory> getAllMemories(){
        return memoryRepository.findAll();
    }

    public List<Model> getAllModels(){
        return modelRepository.findAll();
    }

    public List<OS> getAllOSs(){
        return osRepository.findAll();
    }

    public List<Resolution> getAllResolutions(){
        return resolutionRepository.findAll();
    }

    public List<Size> getAllSize(){
        return sizeRepository.findAll();
    }
}
