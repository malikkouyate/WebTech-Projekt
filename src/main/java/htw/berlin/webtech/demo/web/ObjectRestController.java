package htw.berlin.webtech.demo.web;

import htw.berlin.webtech.demo.service.ObjectService;
import htw.berlin.webtech.demo.web.api.Object;
import htw.berlin.webtech.demo.web.api.ObjectManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

    @GetMapping(path = "/api/v1/objects/{id}")
    public ResponseEntity<Object> collectObjectbyId(@PathVariable Long id) {
        var object = objectService.findById(id);
        return object != null ? ResponseEntity.ok(object) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/objects")
    public ResponseEntity<Void> createObject(@RequestBody ObjectManipulationRequest request) throws URISyntaxException {
        var object = objectService.create(request);
        URI uri = new URI("/api/v1/objects/" + object.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/objects/{id}")
    public ResponseEntity<Object> updateObject (@PathVariable Long id, @RequestBody ObjectManipulationRequest request){
        var object = objectService.update(id, request);
        return object != null ? ResponseEntity.ok(object) : ResponseEntity.notFound().build();
    }
   /* @DeleteMapping(path = "/api/v1/object/{id}")

    public ResponseEntity<Void> deleteObject(@PathVariable Long id) {
        boolean successful = objectService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }*/
    @RequestMapping (path = "/api/v1/objects/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Void> deleteObject(@PathVariable Long id){
        boolean successful = objectService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


}
