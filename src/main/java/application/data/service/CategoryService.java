package application.data.service;

import application.data.model.Category;
import application.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory(){
        try {
            return categoryRepository.findAll();
            //get All Category
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
