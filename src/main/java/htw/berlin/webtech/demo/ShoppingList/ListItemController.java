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

    @PutMapping(path = "{listItemId}")
    public void updateListItem(
            @PathVariable("listItemId")Long listItemId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String link){
        listItemService.updateListItem(listItemId, title, link);
    }

    @DeleteMapping(path="{title}")
    public Object deleteListItem(@PathVariable("title") String title){
        return listItemService.deleteListItem(title);
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
