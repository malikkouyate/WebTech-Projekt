package htw.berlin.webtech.demo.web.api;

public class Object {
    private long id;
    private String objectName;
    private int price;
    private String link;


    public Object(long id, String objectName, int price, String link) {
        this.id = id;
        this.objectName = objectName;
        this.price = price;
        this.link = link;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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



