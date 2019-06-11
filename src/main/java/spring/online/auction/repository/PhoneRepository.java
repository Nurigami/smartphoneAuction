package spring.online.auction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import spring.online.auction.entity.Phone;

import java.util.List;

public interface PhoneRepository extends JpaRepository<Phone, Long> {
    @Query("select p from Phone p where p.brand.id = :brand or :brand is null " +
            "and p.color.id = :color or :color is null " +
            "and p.memory.id = :memory or :memory is null " +
            "and p.model.id = :model or :model is null " +
            "and p.os.id = :os or :os is null " +
            "and p.resolution.id = :resolution or :resolution is null " +
            "and p.size.id = :size or :size is null ")
    List<Phone> searchPhones(@Param("brand") Long brandId, @Param("color") Long colorId,
                             @Param("memory") Long memoryId, @Param("model") Long modelId,
                             @Param("os") Long osId, @Param("resolution") Long resolutionId,
                             @Param("size") Long sizeId);

    @Query("select p from Phone p where p.status = true ")
    List<Phone> getAllActivePhones();

    @Query("select p from Phone p where p.price between :priceOne and :priceTwo ")
    List<Phone> searchPhonesByPrice(@Param("priceOne") Double priceOne, @Param("priceTwo") Double priceTwo);
}
