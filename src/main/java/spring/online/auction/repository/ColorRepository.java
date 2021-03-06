package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.online.auction.entity.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
