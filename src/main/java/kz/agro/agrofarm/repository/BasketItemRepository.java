package kz.agro.agrofarm.repository;


import kz.agro.agrofarm.entity.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author inspiredsamat
 */

@Repository
public interface BasketItemRepository extends JpaRepository<BasketItem, Long> {
}
