package htw.berlin.webtech.demo.ShoppingList;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ListItemService {

    private final ListItemRepository listItemRepository;



    // To-Do Exception werfen wenn title oder link fehlt
    public Object addNewListItem(ListItem listItem) {
        Optional<ListItem> listItemByTitle = listItemRepository
                .findListItemByTitle(listItem.getTitle());
        if(listItemByTitle.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Title already used!");
        }

        if (listItem.getLink().isEmpty() || listItem.getTitle().isEmpty()){
            throw new IllegalStateException("Body is incomplete");
        }

        listItemRepository.save(listItem);
        return "Added successfully!";
    }


    public List<ListItem> getListItems() {
        return listItemRepository.findAll();
    }


    @Transactional
    public Object deleteListItem(String title){

        if(listItemRepository.findListItemByTitle(title).isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Listitem with title " + title + " does not exists!");
        }
        listItemRepository.deleteListItemByTitle(title);
        return "Deleted successfully!";
    }

    public String clearAllListItems(){
        listItemRepository.deleteAll();
        return "cleared all successfully";
    }

    @Transactional
    public void updateListItem(Long listItemId, String title, String link) {

        ListItem listItem = listItemRepository.findById(listItemId)
                .orElseThrow(() -> new IllegalStateException("Listitem does not exist!"));

        if(link != null &&
                link.length() > 0 &&
                !Objects.equals(listItem.getLink(), link)){
            listItem.setLink(link);
        }

        if (title != null &&
                title.length() > 0 &&
                !Objects.equals(listItem.getTitle(), title)){
            Optional<ListItem>listItemOptional = listItemRepository
                    .findListItemByTitle(title);
            if (listItemOptional.isPresent()){
                throw new IllegalStateException("title already used");
            }
            listItem.setTitle(title);
        }

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
