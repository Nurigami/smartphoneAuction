package spring.online.auction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.online.auction.entity.User;
import spring.online.auction.entity.UserRole;
import spring.online.auction.model.Message;
import spring.online.auction.repository.UserRepository;
import spring.online.auction.repository.UserRoleRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public Message addUser(User user) {
        User u = userRepository.save(user);
        UserRole ur = new UserRole(u,"ROLE_USER");
        userRoleRepository.save(ur);
        return new Message("New user account is created");
    }

    @Override
    public Message addAdmin(User user) {
        User u = userRepository.save(user);
        UserRole ur = new UserRole(u,"ROLE_ADMIN");
        userRoleRepository.save(ur);
        return new Message("New admin account is created");
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public Message updateUser(User user) {
        User u = userRepository.findById(user.getId()).orElse(null);
        if(u!=null){
            u.setFio(user.getFio());
            u.setPassword(user.getPassword());
            u.setEmail(user.getEmail());
            u.setPhoneNumber(user.getPhoneNumber());
            userRepository.save(u);
            return new Message("User profile is updated");
        }
        return new Message("User with id " + user.getId() + " does not exist");
    }

    @Override
    public Message blockUser(Long userId) {
        User u = userRepository.findById(userId).orElse(null);
        if(u!= null){
            u.setActive(false);
            userRepository.save(u);
            return new Message("User account is removed");
        }
        return new Message("User with id " + userId + " does not exist");
    }

    @Override
    public Message unblockUser(Long userId) {
        User u = userRepository.findById(userId).orElse(null);
        if(u!= null){
            u.setActive(true);
            userRepository.save(u);
            return new Message("User account is restored");
        }
        return new Message("User with id " + userId + " does not exist");
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }
}
