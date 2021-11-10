package htw.berlin.webtech.demo.persistence;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectRepository  extends JpaRepository<ObjectEntity, Long> {


    List<ObjectEntity> findAllByObjectName(String objectName);
}
