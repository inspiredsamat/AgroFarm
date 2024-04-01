package kz.agro.agrofarm.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Samat Zhumamuratov
 */

@Table(name = "saved_products")
@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SavedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


}
