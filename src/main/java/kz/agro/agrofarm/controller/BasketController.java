package kz.agro.agrofarm.controller;

import kz.agro.agrofarm.model.dto.BasketItemCreateRequestDto;
import kz.agro.agrofarm.model.dto.BasketResponseDto;
import kz.agro.agrofarm.service.BasketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Samat Zhumamuratov
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/basket")
@Slf4j
public class BasketController {

    private final BasketService basketService;

    @PostMapping
    public ResponseEntity<Long> save(@RequestBody BasketItemCreateRequestDto dto) {
        log.info("Trying to add product to basket: {}", dto);
        return ResponseEntity.ok(basketService.save(dto));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<BasketResponseDto> getBasketByUserId(@PathVariable Long userId) {
        log.info("Trying to get basket items of user with id: {}", userId);
        return ResponseEntity.ok(basketService.findByUserId(userId));
    }
}
