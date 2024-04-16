package kz.agro.agrofarm.controller;

import kz.agro.agrofarm.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Samat Zhumamuratov
 */

@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
@Slf4j
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile image) throws IOException {
        return ResponseEntity.ok(imageService.uploadImage(image));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getImageById(@PathVariable Long id) {
        log.info("Trying to get image by id: {}", id);
        byte[] imageData = imageService.getImageById(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
}
