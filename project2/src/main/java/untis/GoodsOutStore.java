package untis;

import java.util.Date;

/**
 * 商品出库库管理
 */
public class GoodsOutStore {
    private Goods goods;
    private Warehouse warehouse;
    private Date outTime;
    private int outQuantity;
    private Employee outEmployee;

    public GoodsOutStore(Goods goods, Warehouse warehouse, Date outTime, int outQuantity, Employee outEmployee) {
        this.goods = goods;
        this.warehouse = warehouse;
        this.outTime = outTime;
        this.outQuantity = outQuantity;
        this.outEmployee = outEmployee;
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

    public Date getOutTime() {
        return outTime;
    }

    public void setOutTime(Date outTime) {
        this.outTime = outTime;
    }

    public int getOutQuantity() {
        return outQuantity;
    }

    public void setOutQuantity(int outQuantity) {
        this.outQuantity = outQuantity;
    }

    public Employee getOutEmployee() {
        return outEmployee;
    }

    public void setOutEmployee(Employee outEmployee) {
        this.outEmployee = outEmployee;
    }
