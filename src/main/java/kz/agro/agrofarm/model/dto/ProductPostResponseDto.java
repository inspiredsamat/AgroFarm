package kz.agro.agrofarm.model.dto;

import kz.agro.agrofarm.model.enums.EProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Samat Zhumamuratov
 */

@Getter
@Setter
@AllArgsConstructor
public class ProductPostResponseDto {
    private Long id;
    private Long imageId;
    private String name;
    private EProductType type;
    private String description;
    private double price;
}
