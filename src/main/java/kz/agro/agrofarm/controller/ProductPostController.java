package kz.agro.agrofarm.controller;

import kz.agro.agrofarm.model.dto.ProductPostCreateRequestDto;
import kz.agro.agrofarm.model.dto.ProductPostResponseDto;
import kz.agro.agrofarm.model.dto.ProductSaveRequestDto;
import kz.agro.agrofarm.service.ProductPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Samat Zhumamuratov
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
@Slf4j
public class ProductPostController {

    private final ProductPostService productPostService;

    @Transactional
    @PostMapping
    public ResponseEntity<String> createNewPost(@ModelAttribute ProductPostCreateRequestDto postDto) {
        log.info("Trying to create a product post: {}", postDto);
        return ResponseEntity.ok(productPostService.createNewPost(postDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPostResponseDto> getProductById(@PathVariable Long id) {
        log.info("Trying to get product post by id: {}", id);
        return ResponseEntity.ok(productPostService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductPostResponseDto>> getAllProductPosts() {
        log.info("Trying to get all product posts");
        return ResponseEntity.ok(productPostService.getAllProductPosts());
    }

    @PostMapping("/saved")
    public void addToSavedProducts(@RequestBody ProductSaveRequestDto dto) {
        log.info("Trying to add to saved products product post with id {}", dto.getProductPostId());
        productPostService.addToSavedProducts(dto.getProductPostId());
    }

    @GetMapping("/saved")
    public ResponseEntity<List<ProductPostResponseDto>> getSavedProducts() {
        log.info("Trying to get saved products");
        return ResponseEntity.ok(productPostService.getSavedProducts());
    }
}
