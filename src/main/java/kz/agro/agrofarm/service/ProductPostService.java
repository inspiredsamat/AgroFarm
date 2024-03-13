package kz.agro.agrofarm.service;

import kz.agro.agrofarm.entity.Image;
import kz.agro.agrofarm.entity.ProductPost;
import kz.agro.agrofarm.entity.User;
import kz.agro.agrofarm.exception.ResourceNotFoundException;
import kz.agro.agrofarm.model.enums.EProductType;
import kz.agro.agrofarm.model.request.ProductPostCreateRequestDto;
import kz.agro.agrofarm.repository.ProductPostRepository;
import kz.agro.agrofarm.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.Principal;

/**
 * @author Samat Zhumamuratov
 */

@Service
@RequiredArgsConstructor
public class ProductPostService {

    private final ProductPostRepository productPostRepository;

    private final UserRepository userRepository;

    public String createNewPost(ProductPostCreateRequestDto postDto, Principal principal) throws IOException {
        User user = userRepository.findByEmail(principal.getName())
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
}
