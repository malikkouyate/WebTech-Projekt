package htw.berlin.webtech.demo;

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
    public java.lang.Object addNewListItem(ListItem listItem) {
        Optional<ListItem> listItemByLink = listItemRepository
                .findListItemByLink(listItem.getLink());
        if(listItemByLink.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Link already used!");
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


    public java.lang.Object deleteListItem(Long listItemId){
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

    @Transactional
    public void updateListItem(Long listItemId, String title, String link) {

        ListItem listItem = listItemRepository.findById(listItemId)
                .orElseThrow(() -> new IllegalStateException("Listitem does not exist!"));

        if(title != null &&
                title.length() > 0 &&
                !Objects.equals(listItem.getTitle(), title)){
            listItem.setTitle(title);
        }

        if (link != null &&
                link.length() > 0 &&
                !Objects.equals(listItem.getLink(), link)){
            Optional<ListItem>listItemOptional = listItemRepository
                    .findListItemByLink(link);
            if (listItemOptional.isPresent()){
                throw new IllegalStateException("link already used");
            }
            listItem.setLink(link);
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
