package saynab.com.memes_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import saynab.com.memes_service.domain.Meme;

@Repository
public interface MemeRepository extends JpaRepository<Meme, Long> {
}
