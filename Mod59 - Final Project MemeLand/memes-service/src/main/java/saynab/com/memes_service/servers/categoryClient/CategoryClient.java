package saynab.com.memes_service.servers.categoryClient;

import org.springframework.stereotype.Service;

@Service
public class CategoryClient {

    private ICategoryClient categoryClient;

    public CategoryClient(ICategoryClient categoryClient) {
        this.categoryClient = categoryClient;
    }

    public Long getCategoryIdByName(String name){
        return categoryClient.getCategoryIdByName(name);
    }
}
