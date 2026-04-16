package saynab.com.memes_service.servers.categoryClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="category-meme-service", dismiss404 = true)
public interface ICategoryClient {

    @GetMapping("/categories/name")
    Long getCategoryIdByName(@RequestParam("name") String name);

}
