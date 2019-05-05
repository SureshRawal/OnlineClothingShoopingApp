package Model;

public class Cloth {
    private String cloth_name;
    private String cloth_price;
    private int cloth_image;
    private String cloth_description;

    public Cloth(String cloth_name, String cloth_price, int cloth_image, String cloth_description) {
        this.cloth_name = cloth_name;
        this.cloth_price = cloth_price;
        this.cloth_image = cloth_image;
        this.cloth_description = cloth_description;
    }

    public String getCloth_name() {
        return cloth_name;
    }

    public void setCloth_name(String cloth_name) {
        this.cloth_name = cloth_name;
    }

    public String getCloth_price() {
        return cloth_price;
    }

    public void setCloth_price(String cloth_price) {
        this.cloth_price = cloth_price;
    }

    public int getCloth_image() {
        return cloth_image;
    }

    public void setCloth_image(int cloth_image) {
        this.cloth_image = cloth_image;
    }

    public String getCloth_description() {
        return cloth_description;
    }

    public void setCloth_description(String cloth_description) {
        this.cloth_description = cloth_description;
    }
}