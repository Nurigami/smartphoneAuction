package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.online.auction.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
