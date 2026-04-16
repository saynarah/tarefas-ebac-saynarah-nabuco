package saynab.com.memes_service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import saynab.com.memes_service.controller.DTOs.CreateMemeDTO;
import saynab.com.memes_service.domain.Meme;
import saynab.com.memes_service.service.MemeService;

@RestController
@RequestMapping("/memes")
public class MemeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MemeController.class);

    private MemeService memeService;

    public MemeController(MemeService memeService) {
        this.memeService = memeService;
    }

    @PostMapping
    public ResponseEntity<Meme> createMeme(@RequestBody CreateMemeDTO memeDTO){

        var memeDB = memeService.createMeme(memeDTO);

        LOGGER.info("New meme created with category ID " + memeDB.getCategoryId() + " and by the userId " + memeDB.getUserId());

        return ResponseEntity.status(HttpStatus.CREATED).body(memeDB);
    }
}
