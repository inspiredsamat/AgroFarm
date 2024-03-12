package kz.agro.agrofarm.model.response;

import kz.agro.agrofarm.model.Content;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Samat Zhumamuratov
 */

@Getter
@Setter
@NoArgsConstructor
public class GeminiResponse {

    private List<Candidate> candidates;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Candidate {
        private Content content;
    }
}
