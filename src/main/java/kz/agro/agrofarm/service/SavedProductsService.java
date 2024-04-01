package kz.agro.agrofarm.service;

import kz.agro.agrofarm.repository.SavedProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Samat Zhumamuratov
 */

@Service
@RequiredArgsConstructor
public class SavedProductsService {

    private final SavedProductsRepository savedProductsRepository;
}
