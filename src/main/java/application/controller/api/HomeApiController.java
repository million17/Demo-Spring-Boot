package application.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApiController {
    @GetMapping("/api/test")
    public ResponseEntity<String> test(){
        return ResponseEntity.ok("Success");
    }
}
