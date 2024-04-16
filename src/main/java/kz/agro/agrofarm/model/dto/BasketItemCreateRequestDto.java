package kz.agro.agrofarm.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Samat Zhumamuratov
 */

@Getter
@Setter
@ToString
public class BasketItemCreateRequestDto {
    private Long productId;
    private int quantity;
}
