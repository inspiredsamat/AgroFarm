package kz.agro.agrofarm.service;

import com.google.cloud.vertexai.VertexAI;
import com.google.cloud.vertexai.api.Content;
import com.google.cloud.vertexai.api.GenerateContentResponse;
import com.google.cloud.vertexai.generativeai.ContentMaker;
import com.google.cloud.vertexai.generativeai.GenerativeModel;
import com.google.cloud.vertexai.generativeai.PartMaker;
import com.google.cloud.vertexai.generativeai.ResponseHandler;
import kz.agro.agrofarm.entity.Image;
import kz.agro.agrofarm.repository.ImageRepository;
import kz.agro.agrofarm.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * @author Samat Zhumamuratov
 */

@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    @Value("${vertex.location}")
    private String location;

    @Value("${vertex.projectId}")
    private String projectId;

    @Value("${vertex.modelName}")
    private String modelName;

    public String uploadImage(MultipartFile image) throws IOException {
        imageRepository.save(
                Image
                        .builder()
                        .data(ImageUtils.compress(image.getBytes()))
                        .build()
        );

        return process(image.getBytes());
    }

    public byte[] getImageById(Long id) {
        Optional<Image> image = imageRepository.findById(id);
        if (image.isEmpty()) {
            throw new RuntimeException();
        }

        return ImageUtils.decompress(image.get().getData());
    }

    public String process(byte[] bytes) throws IOException {
        try (VertexAI vertexAI = new VertexAI(projectId, location)) {
            GenerativeModel model = new GenerativeModel(modelName, vertexAI);
            Content content = ContentMaker.fromMultiModalData(
                    PartMaker.fromMimeTypeAndData("image/jpeg", bytes),
                    "I need a response in json format what kind of agro product I send you, like vegetable or fruit and name ot it"
            );
            GenerateContentResponse response = model.generateContent(content);
            return ResponseHandler.getText(response);
        }
    }
}
