package htw.berlin.webtech.demo.persistence;

import javax.persistence.*;

@Entity(name = "objects")
public class ObjectEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "object_name", nullable = false)
    private String objectName;


    @Column(name = "price")
    private int price;

    @Column(name = "link")
    private String link;

    public ObjectEntity(String objectName, int price) {
        this.objectName = objectName;
        this.price = price;
    }




    @Override
    public String toString(){
        return "Thing{name='"+ objectName +
                "', price=" + price + '}';
    }



    public ObjectEntity( String objectName, int price, String link) {
        this.objectName = objectName;
        this.price = price;
        this.link = link;
    }

    protected ObjectEntity() {

    }

    public Long getId() {
        return id;
    }

    public void  setId(Long id){ this.id = id;}


    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
