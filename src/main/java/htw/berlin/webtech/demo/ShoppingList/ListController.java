package htw.berlin.webtech.demo.ShoppingList;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping(path = "api/v1/list")
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
