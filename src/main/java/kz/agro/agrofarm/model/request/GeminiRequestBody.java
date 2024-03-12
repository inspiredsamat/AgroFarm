package kz.agro.agrofarm.model.request;

import kz.agro.agrofarm.conf.GenerationConfig;
import kz.agro.agrofarm.model.Content;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Samat Zhumamuratov
 */

@Getter
@Setter
public class GeminiRequestBody {

    private List<Content> contents;
    private GenerationConfig generationConfig;
}
