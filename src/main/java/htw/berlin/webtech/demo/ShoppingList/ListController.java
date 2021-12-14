package htw.berlin.webtech.demo.ShoppingList;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/registration/list")
public class ListController {

    private final ListItemService listItemService;

    @GetMapping
    public List<ListItem>getListItems(){
        return listItemService.getListItems();
    }

    @PostMapping
    public void insertListItem(@RequestBody ListItem listItem){
        listItemService.addNewItem(listItem);
    }

}
