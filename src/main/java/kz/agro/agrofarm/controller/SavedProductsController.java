package kz.agro.agrofarm.controller;

import kz.agro.agrofarm.service.SavedProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Samat Zhumamuratov
 */

@RestController
@RequiredArgsConstructor
public class SavedProductsController {

    private final SavedProductsService savedProductsService;
}
