package kz.agro.agrofarm.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Samat Zhumamuratov
 */

@Getter
@Setter
@AllArgsConstructor
public class BasketItemResponseDto {
    private Long productPostId;
    private int quantity;
}
