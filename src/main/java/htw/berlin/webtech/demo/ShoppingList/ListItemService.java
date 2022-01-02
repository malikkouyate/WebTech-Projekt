package htw.berlin.webtech.demo.ShoppingList;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ListItemService {

    private final ListItemRepository listItemRepository;



    public Object addNewListItem(ListItem listItem) {
        Optional<ListItem> listItemByLink = listItemRepository
                .findListItemByLink(listItem.getLink());
        if(listItemByLink.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Link already used!");
        }
        listItemRepository.save(listItem);
        return "Added successfully!";
    }


    public List<ListItem> getListItems() {
        return listItemRepository.findAll();
    }


    public Object deleteListItem(Long listItemId){
        boolean exists = listItemRepository.existsById(listItemId);
        if(!exists){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Listitem with id " + listItemId + " does not exists!");
        }
        listItemRepository.deleteById(listItemId);
        return "Deleted successfully!";
    }

    public String clearAllListItems(){
        listItemRepository.deleteAll();
        return "cleared all successfully";
    }

    /* Um ausgewä
     public String deleteMultipleListItems(List<ListItem>itemList){
         if (itemList.isEmpty()){
             throw new IllegalStateException("itemlist is empty, please selecet Itemes to delete");
         }
         listItemRepository.deleteAll(itemList);
         return "deleted successfully";
     }
     */

}
