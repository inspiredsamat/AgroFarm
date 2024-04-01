package kz.agro.agrofarm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * @author Samat Zhumamuratov
 */

@Entity
@Table(name = "baskets")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private User user;

    @OneToMany(fetch = FetchType.EAGER)
    private List<BasketItem> inBasketProducts;
}
