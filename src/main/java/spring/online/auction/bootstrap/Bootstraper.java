package spring.online.auction.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.online.auction.entity.*;
import spring.online.auction.repository.*;

@Component
public class Bootstraper implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private PhoneRepository phoneRepository;
    @Autowired
    private BidRepository bidRepository;
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

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User("fio","nuri", "123","sample@gmail.com","num");
        User u2 = new User("fio","gami", "456","sample@gmail.com","num2");
        User u3 = new User("fio","uu", "333","sample@gmail.com","num3");
        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);
        UserRole user2 = new UserRole(u3, "ROLE_USER");
        UserRole user = new UserRole(u1, "ROLE_USER");
        UserRole admin = new UserRole(u2, "ROLE_ADMIN");
        userRoleRepository.save(user);
        userRoleRepository.save(admin);
        userRoleRepository.save(user2);
        Brand b1 = new Brand("Apple");
        Brand b2 = new Brand("Samsung");
        Model m1 = new Model("S7");
        Model m2 = new Model("Galaxy S5");
        Color c1 = new Color("Silver");
        Color c2 = new Color("Black");
        Memory me1 = new Memory(3d);
        Memory me2 = new Memory(4d);
        OS o1 = new OS("iOS");
        OS o2 = new OS("Android");
        Resolution r1 = new Resolution(10.5);
        Resolution r2 = new Resolution(12.5);
        Size s1 = new Size(5.5);
        Size s2 = new Size(7.5);
        Phone p1 = new Phone("title","desc","nuri",b1,c1,o1,m1,r1,s2,me1,1200d);
        Phone p2 = new Phone("title","desc","nuri",b2,c2,o2,m2,r2,s2,me2,1100d);
        Phone p3 = new Phone("title","desc","nuri",b2,c2,o2,m2,r2,s2,me2,800d);
        Phone p4 = new Phone("title","desc","nuri",b2,c2,o2,m2,r2,s2,me2,700d);

        brandRepository.save(b1);
        brandRepository.save(b2);
        modelRepository.save(m1);
        modelRepository.save(m2);
        colorRepository.save(c1);
        colorRepository.save(c2);
        memoryRepository.save(me1);
        memoryRepository.save(me2);
        osRepository.save(o1);
        osRepository.save(o2);
        resolutionRepository.save(r1);
        resolutionRepository.save(r2);
        sizeRepository.save(s1);
        sizeRepository.save(s2);
        phoneRepository.save(p1);
        phoneRepository.save(p2);
        phoneRepository.save(p3);
        phoneRepository.save(p4);

    }
}
