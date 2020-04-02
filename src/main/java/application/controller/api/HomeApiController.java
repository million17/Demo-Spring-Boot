package application.controller.api;

import application.data.model.Category;
import application.data.model.New;
import application.data.service.CategoryService;
import application.data.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class HomeApiController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NewService newService;

    @GetMapping("/fake")
    public ResponseEntity<String> fake() {
        List<Category> categoryList = categoryService.getAllCategory();
        List<New> newList = new ArrayList<>();
        Random random = new Random();
        for(long i = 1 ; i<= 3; i++){
            New news = new New();
            news.setTitle("Titile " + i);
            news.setContent("Content " + i);
            news.setThumbnail("Thumbnail " + i);
            news.setShortDesc("Short Description " + i);

            news.setCategory(categoryList.get(random.nextInt(categoryList.size())));
            news.setCreatedDate(new Date());
            newList.add(news);
        }
        newService.addListNews(newList);

        return ResponseEntity.ok("Success !");
    }

    @GetMapping("/api/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Success");
    }
}
