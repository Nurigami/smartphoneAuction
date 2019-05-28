package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.online.auction.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
