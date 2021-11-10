package htw.berlin.webtech.demo.persistence;

import htw.berlin.webtech.demo.web.api.Object;
import htw.berlin.webtech.demo.web.api.ObjectManipulationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObjectService {
    private final ObjectRepository objectRepository;

    public ObjectService (ObjectRepository objectRepository){
        this.objectRepository = objectRepository;
    }

    public List<Object> findAll(){
        List<ObjectEntity> objects = objectRepository.findAll();
        return objects.stream()
            .map(objectEntity -> new Object(
                    objectEntity.getId(),
                    objectEntity.getObjectName(),
                    objectEntity.getPrice(),
                    objectEntity.getLink())
            ).collect(Collectors.toList());
    }

    public Object  findById(Long id) {
        var objectEntity = objectRepository.findById(id);
        return objectEntity.isPresent()? transformEntity(objectEntity.get()) : null;
    }

    public Object create(ObjectManipulationRequest request){
        var objectEntity = new ObjectEntity(request.getObjectName(), request.getPrice(), request.getLink());
        objectEntity = objectRepository.save(objectEntity);
        return transformEntity(objectEntity);

    }


    public Object update ( Long id, ObjectManipulationRequest request){
        var objectEntityOptional = objectRepository.findById(id);
        if(objectEntityOptional.isEmpty()){
            return null;
        }

        var objectEntity = objectEntityOptional.get();
        objectEntity.setObjectName(request.getObjectName());
        objectEntity.setPrice(request.getPrice());
        objectEntity.setLink(request.getLink());
        objectRepository.save(objectEntity);

        return transformEntity(objectEntity);
    }

     private Object transformEntity (ObjectEntity objectEntity){
        return new Object (
                objectEntity.getId(),
                objectEntity.getObjectName(),
                objectEntity.getPrice(),
                objectEntity.getLink()
        );
     }
}
