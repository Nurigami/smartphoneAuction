package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.online.auction.entity.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
