package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.online.auction.entity.Phone;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    @Query("SELECT p FROM Phone p WHERE p.brand = coalesce(cast(CONCAT('%',:brand,'%') as text),p.brand) " +
            "AND p.color = coalesce(cast(CONCAT('%',:color,'%') as text), p.color) " +
            "AND p.opSystem = coalesce(cast(CONCAT('%',:opSystem,'%') as text), p.opSystem) ")
    List<Phone> searchPhones(@Param("brand") String brand, @Param("color") String color, @Param("opSystem") String opSystem);
}
