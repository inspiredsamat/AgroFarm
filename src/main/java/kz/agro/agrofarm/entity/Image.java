package kz.agro.agrofarm.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author Samat Zhumamuratov
 */

@Entity
@Table(name = "images")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(length = 1000)
    private byte[] data;
}
