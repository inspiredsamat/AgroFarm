package kz.agro.agrofarm.repository;

import kz.agro.agrofarm.entity.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Samat Zhumamuratov
 */

public interface BasketRepository extends JpaRepository<Basket, Long> {

    Basket findByUserId(Long userId);
}
