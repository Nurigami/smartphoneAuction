package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.online.auction.entity.Resolution;

public interface ResolutionRepository extends JpaRepository<Resolution, Long> {
}
