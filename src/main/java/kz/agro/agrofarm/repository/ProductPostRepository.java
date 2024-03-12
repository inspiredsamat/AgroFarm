package kz.agro.agrofarm.repository;

import kz.agro.agrofarm.entity.ProductPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Samat Zhumamuratov
 */

@Repository
public interface ProductPostRepository extends JpaRepository<ProductPost, Long> {
}
