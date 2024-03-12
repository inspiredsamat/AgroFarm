package kz.agro.agrofarm.repository;


import kz.agro.agrofarm.entity.Role;
import kz.agro.agrofarm.model.ERole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Samat Zhumamuratov
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(ERole name);
}
