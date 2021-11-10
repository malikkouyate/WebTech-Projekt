package htw.berlin.webtech.demo.web.api;

public class ObjectCreateRequest {


        private String objectName;
        private int price;
        private String link;


        public ObjectCreateRequest(long id, String objectName, int price, String link) {

            this.objectName = objectName;
            this.price = price;
            this.link = link;
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





