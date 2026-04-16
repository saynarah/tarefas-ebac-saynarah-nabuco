package saynab.com.memes_service.service;

import org.springframework.stereotype.Service;
import saynab.com.memes_service.controller.DTOs.CreateMemeDTO;
import saynab.com.memes_service.domain.Meme;
import saynab.com.memes_service.exceptions.ResourceNotFoundException;
import saynab.com.memes_service.repository.MemeRepository;
import saynab.com.memes_service.servers.categoryClient.CategoryClient;
import saynab.com.memes_service.servers.userClient.UserClient;

import java.sql.Date;
import java.time.LocalDate;

@Service
public class MemeService {

    private MemeRepository memeRepository;

    private UserClient userClient;

    private CategoryClient categoryClient;

    public MemeService(CategoryClient categoryClient,
                       UserClient userClient,
                       MemeRepository memeRepository) {
        this.categoryClient = categoryClient;
        this.userClient = userClient;
        this.memeRepository = memeRepository;
    }

    public Meme createMeme(CreateMemeDTO memeDTO){

        Long userId = getUserIdByEmail(memeDTO.userEmail());

        Long categoryId = getCategoryIdByName(memeDTO.categoryName());

        Meme newMeme = new Meme();
        newMeme.setId(null);
        newMeme.setName(memeDTO.name());
        newMeme.setDescription(memeDTO.description());
        newMeme.setUrlMedia(memeDTO.urlMedia());
        newMeme.setCreationDate(Date.valueOf(LocalDate.now()));
        newMeme.setCategoryId(categoryId);
        newMeme.setUserId(userId);
        return memeRepository.save(newMeme);


    }

    private Long getUserIdByEmail(String email){

        Long userId = userClient.getUserByEmail(email);

        if (userId == null){
            throw new ResourceNotFoundException("User not found by email: " + email);
        }

        return userId;
    }

    private Long getCategoryIdByName(String name){

        Long userId = categoryClient.getCategoryIdByName(name);

        if (userId == null){
            throw new ResourceNotFoundException("Category not found by name: " + name);
        }

        return userId;
    }


}
