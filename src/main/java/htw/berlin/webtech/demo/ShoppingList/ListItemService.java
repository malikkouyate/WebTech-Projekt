package htw.berlin.webtech.demo.ShoppingList;

import ch.qos.logback.core.net.SyslogOutputStream;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class ListItemService {

    private final ListItemRepository listItemRepository;

    @Autowired
    public ListItemService(ListItemRepository listItemRepository){
        this.listItemRepository = listItemRepository;
    }

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



}