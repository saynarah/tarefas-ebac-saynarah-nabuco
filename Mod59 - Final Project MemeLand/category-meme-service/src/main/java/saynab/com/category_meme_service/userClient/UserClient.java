package saynab.com.category_meme_service.userClient;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserClient {

    @Autowired
    private IUserClient userClient;

    public Long getUserByEmail(String email){
        return userClient.getUserByEmail(email);
    }


}
