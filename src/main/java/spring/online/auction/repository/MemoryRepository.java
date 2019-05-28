package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.online.auction.entity.Memory;

public interface MemoryRepository extends JpaRepository<Memory, Long> {
}
