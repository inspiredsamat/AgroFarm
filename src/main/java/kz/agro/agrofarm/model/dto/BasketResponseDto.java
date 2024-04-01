package kz.agro.agrofarm.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Samat Zhumamuratov
 */

@Getter
@Setter
@AllArgsConstructor
public class BasketResponseDto {
    private List<BasketItemResponseDto> itemDtos;
}
