package untis;

/**
 * 商品
 */
public class Goods {
    //商品编号、商品名称、品牌、规格、产地、价格
    private String goodsNo;
    private String name;
    private String brand;
    private String specification;
    private String origin;
    private double price;

    public Goods(String goodsNo, String name, String brand, String specification, String origin, double price) {
        this.goodsNo = goodsNo;
        this.name = name;
        this.brand = brand;
        this.specification = specification;
        this.origin = origin;
        this.price = price;
    }

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}