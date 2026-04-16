package saynab.com.memes_service.controller.DTOs;

public record CreateMemeDTO(String name,
                            String description,
                            String urlMedia,
                            String categoryName,
                            String userEmail
                            ) {
}
