package kz.agro.agrofarm.service;

import kz.agro.agrofarm.entity.Basket;
import kz.agro.agrofarm.entity.BasketItem;
import kz.agro.agrofarm.entity.ProductPost;
import kz.agro.agrofarm.entity.User;
import kz.agro.agrofarm.exception.ResourceNotFoundException;
import kz.agro.agrofarm.model.dto.BasketItemCreateRequestDto;
import kz.agro.agrofarm.model.dto.BasketItemResponseDto;
import kz.agro.agrofarm.model.dto.BasketResponseDto;
import kz.agro.agrofarm.repository.BasketItemRepository;
import kz.agro.agrofarm.repository.BasketRepository;
import kz.agro.agrofarm.repository.ProductPostRepository;
import kz.agro.agrofarm.repository.UserRepository;
import kz.agro.agrofarm.util.AuthUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Samat Zhumamuratov
 */

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;
    private final UserRepository userRepository;
    private final ProductPostRepository productPostRepository;
    private final BasketItemRepository basketItemRepository;

    public Long save(BasketItemCreateRequestDto dto) {
        String email = AuthUtils.getLoggedInUserEmail();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " not found"));

        ProductPost productPost = productPostRepository.findById(dto.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product post with id " + dto.getProductId() + " not found"));

        BasketItem item = new BasketItem();
        item.setProductPost(productPost);
        item.setQuantity(dto.getQuantity());

        Basket userBasket = basketRepository.findByUserId(user.getId());

        if (userBasket == null) {
            userBasket = basketRepository.save(new Basket());
            userBasket.setInBasketProducts(new ArrayList<>());
            userBasket.setUser(user);
        }

        basketItemRepository.save(item);
        userBasket.getInBasketProducts().add(item);
        basketRepository.save(userBasket);
        return userBasket.getId();
    }

    public BasketResponseDto findByUserId(Long userId) {
        Basket basketFromDb = basketRepository.findByUserId(userId);
        List<BasketItem> inBasketProducts = basketFromDb.getInBasketProducts();

        List<BasketItemResponseDto> itemDtos = inBasketProducts.stream().map(product -> {
            BasketItemResponseDto itemDto = new BasketItemResponseDto();
            itemDto.setQuantity(product.getQuantity());
            itemDto.setProductPost(product.getProductPost());
            return itemDto;
        }).collect(Collectors.toList());

        return new BasketResponseDto(itemDtos);
    }
}
