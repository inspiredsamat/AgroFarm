package kz.agro.agrofarm.controller;

import kz.agro.agrofarm.entity.ProductPost;
import kz.agro.agrofarm.model.dto.ProductPostCreateRequestDto;
import kz.agro.agrofarm.service.ProductPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author Samat Zhumamuratov
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class ProductPostController {

    private final ProductPostService productPostService;

    @Transactional
    @PostMapping
    public ResponseEntity<String> createNewPost(@ModelAttribute ProductPostCreateRequestDto postDto) {
        try {
            return ResponseEntity.ok(productPostService.createNewPost(postDto));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPost> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productPostService.getProductById(id));
    }
}
