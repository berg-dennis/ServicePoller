package kry.codetest.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> healthCheck(){
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

}
