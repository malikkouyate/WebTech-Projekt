package htw.berlin.webtech.demo.web;

import htw.berlin.webtech.demo.persistence.ObjectRepository;
import htw.berlin.webtech.demo.persistence.ObjectService;
import htw.berlin.webtech.demo.web.api.Object;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObjectRestController {

    private final ObjectService objectService;

    public ObjectRestController(ObjectService objectService) {
        this.objectService = objectService;
    }

    @GetMapping(path = "/api/v1/objects")
     public ResponseEntity<List<Object>> collectObjects() {
        return ResponseEntity.ok(objectService.findAll());
    }

}
