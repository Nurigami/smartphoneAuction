package spring.online.auction.service;

import spring.online.auction.entity.User;
import spring.online.auction.model.Message;

import java.util.List;

public interface UserService {
    Message addUser(User user);
    Message addAdmin(User user);
    User getUserById(Long userId);
    Message updateUser(User user);
    Message blockUser(Long userId);
    Message unblockUser(Long userId);
    List<User> getAllUsers();
    User getUserByLogin(String login);
}
