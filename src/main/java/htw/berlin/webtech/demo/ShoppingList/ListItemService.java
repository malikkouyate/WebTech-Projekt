package htw.berlin.webtech.demo.ShoppingList;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ListItemService {

    private final ListItemRepository listItemRepository;



    public void addNewListItem(ListItem listItem) {
        Optional<ListItem> listItemByLink = listItemRepository
                .findListItemByLink(listItem.getLink());
        if(listItemByLink.isPresent()){
            throw new IllegalStateException("Link already used");
        }
        listItemRepository.save(listItem);
    }


    public List<ListItem> getListItems() {
        return listItemRepository.findAll();
    }


    public void deleteListItem(Long listItemId){
        boolean exists = listItemRepository.existsById(listItemId);
        if(!exists){
            throw new IllegalStateException("Listitem with id " + listItemId + " does not exists");
        }
        listItemRepository.deleteById(listItemId);
    }

    public String clearAllListItems(){
        listItemRepository.deleteAll();
        return "cleared all successfully";
    }

    /*
     public String deleteMultipleListItems(List<ListItem>itemList){
         if (itemList.isEmpty()){
             throw new IllegalStateException("itemlist is empty, please selecet Itemes to delete");
         }
         listItemRepository.deleteAll(itemList);
         return "deleted successfully";
     }
     */

}