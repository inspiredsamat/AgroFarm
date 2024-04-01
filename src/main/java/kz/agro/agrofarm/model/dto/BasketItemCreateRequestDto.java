package kz.agro.agrofarm.model.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Samat Zhumamuratov
 */

@Getter
@Setter
public class BasketItemCreateRequestDto {
    private Long productId;
    private int quantity;
}
