package saynab.com.memes_service.servers.userClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "User-Service", dismiss404 = true)
public interface IUserClient {

    @GetMapping("/users")
    Long getUserByEmail(@RequestParam("email") String email);

}

