package htw.berlin.webtech.demo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table
@Getter
@Setter
public class ListItem {

    @SequenceGenerator(
            name = "list_item_sequence",
            sequenceName = "list_item_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "list_item_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String title;

    private String link;

    public ListItem(String title,
                    String link ) {
        this.title = title;
        this.link = link;
    }

    public ListItem(Long id, String title, String link) {
        this.id = id;
        this.title = title;
        this.link = link;
    }


    @Override
    public String toString() {
        return "ListItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
