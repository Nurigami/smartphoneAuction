package spring.online.auction.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import spring.online.auction.entity.Phone;
import spring.online.auction.entity.User;
import spring.online.auction.entity.UserRole;
import spring.online.auction.model.Brand;
import spring.online.auction.model.Color;
import spring.online.auction.model.OpSystem;
import spring.online.auction.repository.PhoneRepository;
import spring.online.auction.repository.UserRepository;
import spring.online.auction.repository.UserRoleRepository;

@Component
public class Bootstraper implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public void run(String... args) throws Exception {
/*        User u1 = new User("fio","nuri", "123","email","num");
        User u2 = new User("fio","gami", "456","email2","num2");
        User u3 = new User("fio","user3", "333","email3","num3");
        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);
        UserRole user2 = new UserRole(u3, "ROLE_USER");
        UserRole user = new UserRole(u1, "ROLE_USER");
        UserRole admin = new UserRole(u2, "ROLE_ADMIN");
        userRoleRepository.save(user);
        userRoleRepository.save(admin);
        userRoleRepository.save(user2);*/
        /*Phone p1 = new Phone("desc",Brand.Apple.toString(), Color.Black.toString(), OpSystem.iOS.toString(),
                2.3d,40.5d,4,1000d,"nuri");
        Phone p2 = new Phone("desc2",Brand.Samsung.toString(), Color.White.toString(), OpSystem.Android.toString(),
                4.5d,50.5d,7,1200d,"user3");
        phoneRepository.save(p1);
        phoneRepository.save(p2);*/
    }
}
