package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.online.auction.entity.Size;

public interface SizeRepository extends JpaRepository<Size, Long> {
}
