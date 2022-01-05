package htw.berlin.webtech.demo.ShoppingList;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListItemRepository extends JpaRepository<ListItem, Long> {

    @Query("SELECT l FROM ListItem l where l.link = ?1")
    Optional<ListItem> findListItemByLink(String link);
}
