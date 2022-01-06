package htw.berlin.webtech.demo.ShoppingList;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListItemRepository extends JpaRepository<ListItem, Long> {

    @Query("SELECT l FROM ListItem l where l.title = ?1")
    Optional<ListItem> findListItemByTitle(String title);

    @Modifying
    @Query("delete from ListItem l where l.title=:title")
   void deleteListItemByTitle(@Param("title")String title);
}
