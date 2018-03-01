package domain;

public class Food {
    private int id;
    private String name;
    private String pic_Url;
    private int price;

    public Food(int id, String name, String pic_Url, int price){
        this.id = id;
        this.name = name;
        this.pic_Url = pic_Url;
        this.price = price;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic_Url() {
        return pic_Url;
    }

    public void setPic_Url(String pic_Url) {
        this.pic_Url = pic_Url;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
