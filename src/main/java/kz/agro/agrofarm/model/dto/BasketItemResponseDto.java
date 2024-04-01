package kz.agro.agrofarm.model.dto;

import kz.agro.agrofarm.entity.ProductPost;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Samat Zhumamuratov
 */

@Getter
@Setter
public class BasketItemResponseDto {
    private ProductPost productPost;
    private int quantity;
}
