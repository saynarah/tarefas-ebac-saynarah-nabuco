package saynab.com.category_meme_service.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import saynab.com.category_meme_service.controller.CategoryController;
import saynab.com.category_meme_service.controller.dtos.CreateMemeCategoryDTO;
import saynab.com.category_meme_service.domain.CategoryMeme;
import saynab.com.category_meme_service.exceptions.CategoryAlreadyExistsException;
import saynab.com.category_meme_service.exceptions.UserNotFoundException;
import saynab.com.category_meme_service.repository.CategoryMemeRepository;
import saynab.com.category_meme_service.userClient.UserClient;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class CategoryMemeService {

    private CategoryMemeRepository categoryMemeRepository;

    private UserClient userClient;

    public CategoryMemeService(CategoryMemeRepository categoryMemeRepository,
                               UserClient userClient) {
        this.categoryMemeRepository = categoryMemeRepository;
        this.userClient = userClient;
    }

    public CategoryMeme createMemeCategory(CreateMemeCategoryDTO categoryDTO) {

        categoryExistsCheck(categoryDTO.name());

        Long userId = userExistsCheck(categoryDTO.emailUser());

        CategoryMeme newCategory = new CategoryMeme();
        newCategory.setId(null);
        newCategory.setName(categoryDTO.name());
        newCategory.setDescription(categoryDTO.description());
        newCategory.setCreationDate(Date.valueOf(LocalDate.now()));
        newCategory.setUserId(userId);
        return categoryMemeRepository.save(newCategory);

    }


    public Long findByCategoryName(String name) {

        return categoryMemeRepository.findByName(name)
                .map(CategoryMeme::getId).orElse(null);

    }


    private Void categoryExistsCheck(String name) {

        var categoryDB = categoryMemeRepository.findByName(name).map(CategoryMeme::getId);

        if (categoryDB.isPresent()) {
            throw new CategoryAlreadyExistsException("Category already exists by name: " + name);
        }
        return null;
    }

    private Long userExistsCheck(String email) {

        Long userId = userClient.getUserByEmail(email);

        if (userId == null){
            throw new UserNotFoundException("User not found by email: " + email);}

        return userId;
    }

}


