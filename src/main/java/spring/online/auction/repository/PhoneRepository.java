package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.online.auction.entity.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
