package kz.agro.agrofarm.controller;

import kz.agro.agrofarm.entity.ProductPost;
import kz.agro.agrofarm.model.dto.ProductPostCreateRequestDto;
import kz.agro.agrofarm.service.ProductPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ProductPost> getProductById(@PathVariable Long id) {
        log.info("Trying to get product post by id: {}", id);
        return ResponseEntity.ok(productPostService.getProductById(id));
    }
}
