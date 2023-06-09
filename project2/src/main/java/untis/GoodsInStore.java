package untis;

import java.util.Date;

/**
 * 商品入库管理
 */
public class GoodsInStore {
    private Goods goods;
    private Warehouse warehouse;
    private Date inTime;
    private int inQuantity;
    private Employee inEmployee;

    public GoodsInStore(Goods goods, Warehouse warehouse, Date inTime, int inQuantity, Employee inEmployee) {
        this.goods = goods;
        this.warehouse = warehouse;
        this.inTime = inTime;
        this.inQuantity = inQuantity;
        this.inEmployee = inEmployee;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
    }

    public int getInQuantity() {
        return inQuantity;
    }

    public void setInQuantity(int inQuantity) {
        this.inQuantity = inQuantity;
    }

    public Employee getInEmployee() {
        return inEmployee;
    }

    public void setInEmployee(Employee inEmployee) {
        this.inEmployee = inEmployee;
    }
}
