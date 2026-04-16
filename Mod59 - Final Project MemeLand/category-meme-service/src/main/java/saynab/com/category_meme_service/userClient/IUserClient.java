package saynab.com.category_meme_service.userClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "User-Service", dismiss404 = true)
public interface IUserClient {

    @GetMapping("/users")
    @ResponseBody
    Long getUserByEmail(@RequestParam("email") String email);

}

