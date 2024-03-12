package kz.agro.agrofarm.controller;

import kz.agro.agrofarm.model.Content;
import kz.agro.agrofarm.model.request.GeminiRequestBody;
import kz.agro.agrofarm.model.response.GeminiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Samat Zhumamuratov
 */

@RequestMapping("/api/v1/")
@RestController
public class GeminiApiController {

    private final RestTemplate restTemplate;

    public GeminiApiController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${gemini.api.key}")
    private String key;

    @Value("${gemini.api.url}")
    private String url;

    @GetMapping("/chat")
    public ResponseEntity<GeminiResponse> chat(@RequestParam String prompt) {
        GeminiRequestBody requestBody = new GeminiRequestBody();
        requestBody.setContents(List.of(new Content("user", List.of(new Content.Part(prompt)))));

        return ResponseEntity.ok(restTemplate.postForObject(url + key, requestBody, GeminiResponse.class));
    }

}
