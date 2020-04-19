package application.controller.api;

import application.data.model.Category;
import application.data.model.New;
import application.data.service.CategoryService;
import application.data.service.NewService;
import application.model.api.NewOutputDTO;
import application.model.dto.NewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class NewApiController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private NewService newService;

    @GetMapping("/api/new/fake")
    public ResponseEntity<String> fake() {
        List<Category> categoryList = categoryService.getAllCategory();//getAllCategory
        List<New> newList = new ArrayList<>();//Create List New
        Random random = new Random();//Random
        for (long i = 1; i <= 10; i++) {
            New news = new New();
            news.setTitle("Title " + i);
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

    @GetMapping("/api/new")
    public NewOutputDTO showNew(@RequestParam("page") int page,
                                @RequestParam("limit") int limit) {
        NewOutputDTO result = new NewOutputDTO();
        Pageable pageable = new PageRequest(page -1 ,limit);
        result.setPage(page);
        result.setListResult(newService.getAllNews(pageable));
        result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
        return result;
    }

    @PostMapping("/api/new")
    public NewDTO create(@RequestBody NewDTO model) {
        return newService.save(model);
    }

    @PutMapping("/api/new/{id}")
    public NewDTO update(@RequestBody NewDTO model, @PathVariable("id") long id) {
        model.setId(id);
        return newService.save(model);
    }

    @DeleteMapping("/api/new")
    public void delete(@RequestBody long[] ids) {
        newService.delete(ids);
    }
}
