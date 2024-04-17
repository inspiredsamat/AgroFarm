package kz.agro.agrofarm.service;

import kz.agro.agrofarm.entity.BasketItem;
import kz.agro.agrofarm.entity.User;
import kz.agro.agrofarm.exception.ResourceNotFoundException;
import kz.agro.agrofarm.model.dto.BasketItemCreateRequestDto;
import kz.agro.agrofarm.repository.BasketItemRepository;
import kz.agro.agrofarm.repository.ProductPostRepository;
import kz.agro.agrofarm.repository.UserRepository;
import kz.agro.agrofarm.util.AuthUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Samat Zhumamuratov
 */

@Service
@RequiredArgsConstructor
public class BasketService {
    private final UserRepository userRepository;
    private final ProductPostRepository productPostRepository;
    private final BasketItemRepository basketItemRepository;

    public Long save(BasketItemCreateRequestDto dto) {
        String email = AuthUtils.getLoggedInUserEmail();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User with email " + email + " not found"));

        productPostRepository.findById(dto.getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product post with id " + dto.getProductId() + " not found"));

        if (user.getInBasketProducts() == null) {
            user.setInBasketProducts(new ArrayList<>());
        }

        BasketItem item = basketItemRepository.save(new BasketItem(dto.getProductId(), dto.getQuantity()));
        user.getInBasketProducts().add(item);
        userRepository.save(user);

        return item.getId();
    }

    public List<BasketItem> findByUserId(Long userId) {
        User userFromDb = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found"));
        return userFromDb.getInBasketProducts();
    }
}
