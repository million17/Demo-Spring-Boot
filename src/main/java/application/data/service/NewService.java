package application.data.service;

import application.converter.NewConverter;
import application.data.model.Category;
import application.data.model.New;
import application.data.repository.CategoryRepository;
import application.data.repository.NewRepository;
import application.model.dto.NewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewService {
    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    @Transactional
    public void addListNews(List<New> newList ){
        newRepository.save(newList);
    }

    public List<NewDTO> getAllNews(Pageable pageable){
        List<NewDTO> result = new ArrayList<>();
        List<New> newList = newRepository.findAll(pageable).getContent();
        for (New news : newList) {
            NewDTO newDTO = newConverter.toDTO(news);
            result.add(newDTO);
        }

        return result;
    }

    public int totalItem() {
        return (int) newRepository.count();
    }

    @Transactional
    public NewDTO save(NewDTO newDTO) {
        New news = new New();
        if(newDTO.getId() != null ){
            New oldNew = newRepository.findOne(newDTO.getId());
            news = newConverter.toEntity(oldNew,newDTO);
        } else {
            news = newConverter.toEntity(newDTO);
        }
        Category category = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        news.setCategory(category);
        news = newRepository.save(news);
        return newConverter.toDTO(news);
    }

    public void delete(long[] ids) {
        for(long id : ids){
            newRepository.delete(id);
        }

    }
}
