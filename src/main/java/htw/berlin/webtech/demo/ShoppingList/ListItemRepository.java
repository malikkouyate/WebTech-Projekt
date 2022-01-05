package htw.berlin.webtech.demo.ShoppingList;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListItemRepository extends JpaRepository<ListItem, Long> {

    @Query("SELECT l FROM ListItem l where l.link = ?1")
    Optional<ListItem> findListItemByLink(String link);

    @Modifying
    @Query("delete from ListItem l where l.link=:link")
   void deleteListItemByLink(@Param("link")String link);
}
