package htw.berlin.webtech.demo;

import htw.berlin.webtech.demo.ObjectEntity;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ObjectEntityTest {

    @Test
    void TestToString(){
        String objectName = "Ding";
        int price = 99;

        ObjectEntity objectEntity = new ObjectEntity(objectName, price);



        String expected = "Thing{name='Ding', price=99}";

        String actual = objectEntity.toString();

        assertEquals(expected,actual);
    }
}
