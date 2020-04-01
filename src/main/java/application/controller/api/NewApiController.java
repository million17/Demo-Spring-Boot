package application.controller.api;

import application.data.service.NewService;
import application.model.dto.NewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class NewApiController {

    @Autowired
    private NewService newService;

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
