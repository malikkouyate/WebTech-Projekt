package htw.berlin.webtech.demo;

import htw.berlin.webtech.demo.ListItem;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListItemTest{

    @Test
    void TestToString(){
        Long id = 7L;
        String title = "youtube.com";
        String link = "TV";

        ListItem listItem = new ListItem(id,title, link);



        String expected = "ListItem{id=7, title='youtube.com', link='TV'}";

        String actual = listItem.toString();

        assertEquals(expected,actual);
    }
}
