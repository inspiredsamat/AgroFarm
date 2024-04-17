package kz.agro.agrofarm.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Samat Zhumamuratov
 */

@Entity
@Table(name = "basket_items")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasketItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productPostId;

    @Column(nullable = false)
    private int quantity;

    public BasketItem(Long productPostId, int quantity) {
        this.productPostId = productPostId;
        this.quantity = quantity;
    }
}
