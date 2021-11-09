package htw.berlin.webtech.demo.web;

import htw.berlin.webtech.demo.web.api.Object;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ObjectRestController {

    private List <Object> objects;

    public ObjectRestController() {
        objects = new ArrayList<>();
        objects.add(new Object(1, "Kabel", 5, "test123"));
        objects.add(new Object(2, "Handy", 500, "test1234"));
    }

    @GetMapping(path = "/api/v1/objects")
     public ResponseEntity<List<Object>> collectObjects() {
        return ResponseEntity.ok(objects);
    }
}
