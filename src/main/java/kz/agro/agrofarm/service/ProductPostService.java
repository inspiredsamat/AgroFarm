package kz.agro.agrofarm.service;

import kz.agro.agrofarm.entity.Image;
import kz.agro.agrofarm.entity.ProductPost;
import kz.agro.agrofarm.entity.User;
import kz.agro.agrofarm.exception.ResourceNotFoundException;
import kz.agro.agrofarm.model.enums.EProductType;
import kz.agro.agrofarm.model.dto.ProductPostCreateRequestDto;
import kz.agro.agrofarm.repository.ProductPostRepository;
import kz.agro.agrofarm.repository.UserRepository;
import kz.agro.agrofarm.util.AuthUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

/**
 * @author Samat Zhumamuratov
 */

@Service
@RequiredArgsConstructor
public class ProductPostService {

    private final ProductPostRepository productPostRepository;

    private final UserRepository userRepository;

    @SneakyThrows
    public String createNewPost(ProductPostCreateRequestDto postDto) {
        User user = userRepository.findByEmail(AuthUtils.getLoggedInUserEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User with this email not found"));

        ProductPost postToCreate =
                ProductPost
                        .builder()
                        .image(new Image(postDto.getImageId(), postDto.getImage().getBytes()))
                        .name(postDto.getName())
                        .type(EProductType.valueOf(postDto.getType().toUpperCase()))
                        .description(postDto.getDescription())
                        .price(postDto.getPrice())
                        .user(user)
                        .build();

        user.getPosts().add(postToCreate);
        productPostRepository.save(postToCreate);
        userRepository.save(user);

        return "Success";
    }

    public ProductPost getProductById(Long id) {
        return productPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product post with id " + id + " not found"));
    }
}
