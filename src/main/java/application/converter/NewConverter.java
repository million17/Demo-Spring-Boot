package application.converter;

import application.data.model.New;
import application.model.dto.NewDTO;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class NewConverter {

    public NewDTO toDTO(New entity){

        NewDTO result = new NewDTO();
        if (result.getId() != null) {
            result.setId(result.getId());
        }
        result.setTitle(entity.getTitle());
        result.setContent(entity.getContent());
        result.setShortDesc(entity.getShortDesc());
        result.setThumbnail(entity.getThumbnail());
        result.setCategoryCode(entity.getCategory().getCode());
        result.setCategoryName(entity.getCategory().getName());
        result.setModifiedBy(entity.getModifiedBy());
        result.setCreatedBy(entity.getCreatedBy());
        result.setModifiedDate(entity.getModifiedDate());
        result.setCreatedDate(entity.getCreatedDate());
        return result;
    }


    public New toEntity(NewDTO dto){
        New result = new New();
        result.setTitle(dto.getTitle());
        result.setContent(dto.getContent());
        result.setShortDesc(dto.getShortDesc());
        result.setThumbnail(dto.getThumbnail());
        return result;

    }

    public New toEntity(New result, NewDTO dto){
        result.setTitle(dto.getTitle());
        result.setContent(dto.getContent());
        result.setShortDesc(dto.getShortDesc());
        result.setThumbnail(dto.getThumbnail());

        return result;

    }
}
