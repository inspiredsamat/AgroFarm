package kz.agro.agrofarm.model;

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
public class Content {

    private String role;
    private List<Part> parts;

    public Content(String role, List<Part> parts) {
        this.role = role;
        this.parts = parts;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Part {

        private String text;

        public Part(String text) {
            this.text = text;
        }
    }
}
