package htw.berlin.webtech.demo.ShoppingList;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/registration/list")
public class ListItemController {

    private final ListItemService listItemService;

    @GetMapping
    public List<ListItem>getListItems(){
        return listItemService.getListItems();
    }

    @PostMapping
    public Object insertListItem(@RequestBody ListItem listItem){
        return listItemService.addNewListItem(listItem);
    }

    @DeleteMapping(path="{listItemId}")
    public Object deleteListItem(@PathVariable("listItemId") Long listItemId){
        return listItemService.deleteListItem(listItemId);
    }

    @DeleteMapping(path = "/deleteAll")
    public String deleteAllListItems(){
        return listItemService.clearAllListItems();
    }



//    @DeleteMapping(path = "/deleteMultiple")
//    public String deleteMultipleListItems(@RequestBody List<ListItem>itemList){
//        return listItemService.deleteMultipleListItems(itemList);
//    }

}
