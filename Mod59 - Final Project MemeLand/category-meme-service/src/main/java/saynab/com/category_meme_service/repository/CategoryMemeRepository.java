package saynab.com.category_meme_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saynab.com.category_meme_service.domain.CategoryMeme;

import java.util.Optional;

@Repository
public interface CategoryMemeRepository extends JpaRepository<CategoryMeme,Long> {

    Optional<CategoryMeme> findByName(String name);
}
