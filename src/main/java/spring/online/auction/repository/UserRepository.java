package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.online.auction.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
