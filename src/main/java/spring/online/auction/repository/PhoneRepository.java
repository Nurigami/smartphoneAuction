package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.online.auction.entity.Phone;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    @Query("SELECT p FROM Phone p WHERE p.brand.id = :brand")
    List<Phone> searchPhones(@Param("brand") Long brandId);

    @Query("SELECT p from Phone p WHERE p.status = true ")
    List<Phone> getAllActivePhones();
}
