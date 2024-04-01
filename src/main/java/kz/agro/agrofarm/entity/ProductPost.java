package kz.agro.agrofarm.entity;

import jakarta.persistence.*;
import kz.agro.agrofarm.model.enums.EProductType;
import lombok.*;

/**
 * @author Samat Zhumamuratov
 */

@Entity
@Table(name = "posts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EProductType type;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;
}
