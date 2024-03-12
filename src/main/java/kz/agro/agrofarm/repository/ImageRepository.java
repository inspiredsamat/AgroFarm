package kz.agro.agrofarm.repository;


import kz.agro.agrofarm.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Samat Zhumamuratov
 */

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
