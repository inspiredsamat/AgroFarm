package kz.agro.agrofarm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_post_id")
    @JsonIgnore
    private ProductPost productPost;

    @Column(nullable = false)
    private int quantity;

}
