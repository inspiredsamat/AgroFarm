package kz.agro.agrofarm.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Samat Zhumamuratov
 */

@Getter
@Setter
public class ProductPostCreateRequestDto {
    private MultipartFile image;
    private Long imageId;
    private String name;
    private String description;
    private String type;
    private double price;
}
