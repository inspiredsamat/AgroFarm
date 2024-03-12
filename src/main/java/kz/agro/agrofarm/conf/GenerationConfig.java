package kz.agro.agrofarm.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Samat Zhumamuratov
 */

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "gemini.api")
public class GenerationConfig {
    private double temperature;
    private int topK;
    private int topP;
    private int maxOutputTokens;
    private List<String> stopSequences = new ArrayList<>();
}
