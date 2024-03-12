package kz.agro.agrofarm.controller;

import kz.agro.agrofarm.model.request.ProductPostCreateRequestDto;
import kz.agro.agrofarm.service.ProductPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.Principal;

/**
 * @author Samat Zhumamuratov
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class ProductPostController {

    private final ProductPostService productPostService;

    @PostMapping
    public ResponseEntity<String> createNewPost(@ModelAttribute ProductPostCreateRequestDto postDto, Principal principal) {
        try {
            return ResponseEntity.ok(productPostService.createNewPost(postDto, principal));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
