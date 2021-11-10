package htw.berlin.webtech.demo.persistence;

import htw.berlin.webtech.demo.persistence.ObjectEntity;
import htw.berlin.webtech.demo.persistence.ObjectRepository;
import htw.berlin.webtech.demo.web.api.Object;
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
}
