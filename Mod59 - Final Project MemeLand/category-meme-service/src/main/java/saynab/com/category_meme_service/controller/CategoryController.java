package saynab.com.category_meme_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import saynab.com.category_meme_service.controller.dtos.CreateMemeCategoryDTO;
import saynab.com.category_meme_service.domain.CategoryMeme;
import saynab.com.category_meme_service.service.CategoryMemeService;

import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryMemeService categoryMemeService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    public CategoryController(CategoryMemeService categoryMemeService) {
        this.categoryMemeService = categoryMemeService;
    }

    @PostMapping
    public ResponseEntity<CategoryMeme> createMemeCategory(@RequestBody CreateMemeCategoryDTO memeCategoryDTO){

        var categoryCreated = categoryMemeService.createMemeCategory(memeCategoryDTO);

        LOGGER.info("Category created by name " + categoryCreated.getName() + " with ID "
                + categoryCreated.getId().toString() + " and userId " + categoryCreated.getUserId().toString());

        return ResponseEntity.ok(categoryCreated);

    }

    @GetMapping("/name")
    public ResponseEntity<Long> getCategoryIdByName(@RequestParam("name") String name){

        var categoryDB = categoryMemeService.findByCategoryName(name);

        if(categoryDB != null){
            LOGGER.info("Category find by name " + name + " with ID " + categoryDB.toString());
            return ResponseEntity.ok(categoryDB);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(categoryDB);
        }
    }
}
