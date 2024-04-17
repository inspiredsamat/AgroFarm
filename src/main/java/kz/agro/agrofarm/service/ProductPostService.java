package kz.agro.agrofarm.service;

import kz.agro.agrofarm.entity.Image;
import kz.agro.agrofarm.entity.ProductPost;
import kz.agro.agrofarm.entity.User;
import kz.agro.agrofarm.exception.ResourceNotFoundException;
import kz.agro.agrofarm.model.dto.ProductPostResponseDto;
import kz.agro.agrofarm.model.enums.EProductType;
import kz.agro.agrofarm.model.dto.ProductPostCreateRequestDto;
import kz.agro.agrofarm.repository.ProductPostRepository;
import kz.agro.agrofarm.repository.UserRepository;
import kz.agro.agrofarm.util.AuthUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public ProductPostResponseDto getProductById(Long id) {
        ProductPost productPost = productPostRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product post with id " + id + " not found"));
        return new ProductPostResponseDto(productPost.getId(),
                                          productPost.getImage().getId(),
                                          productPost.getName(),
                                          productPost.getType(),
                                          productPost.getDescription(),
                                          productPost.getPrice());
    }

    public List<ProductPostResponseDto> getAllProductPosts() {
        return productPostRepository.findAll()
                .stream()
                .map(
                        productPost -> new ProductPostResponseDto(productPost.getId(),
                                productPost.getImage().getId(),
                                productPost.getName(),
                                productPost.getType(),
                                productPost.getDescription(),
                                productPost.getPrice())
                ).collect(Collectors.toList());
    }

    public void addToSavedProducts(Long productPostId) {
        String email = AuthUtils.getLoggedInUserEmail();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " not found"));
        ProductPost productPostFromDb = productPostRepository.findById(productPostId).orElseThrow(() -> new ResourceNotFoundException("Product post with id " + productPostId + " not found"));

        if (user.getSavedProducts() == null) {
            user.setSavedProducts(new ArrayList<>());
        }

        user.getSavedProducts().add(productPostFromDb);
        userRepository.save(user);
    }

    public List<ProductPostResponseDto> getSavedProducts() {
        String email = AuthUtils.getLoggedInUserEmail();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " not found"));

        return user.getSavedProducts().stream()
                .map(
                        productPost -> new ProductPostResponseDto(productPost.getId(),
                                productPost.getImage().getId(),
                                productPost.getName(),
                                productPost.getType(),
                                productPost.getDescription(),
                                productPost.getPrice())
                ).collect(Collectors.toList());
    }
}
