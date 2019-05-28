package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.online.auction.entity.OS;

public interface OSRepository extends JpaRepository<OS, Long> {
}
