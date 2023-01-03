    package com.kc.design.factory.idcard;

    import com.kc.design.factory.framework.Factory;
    import com.kc.design.factory.framework.Product;

    import java.util.ArrayList;
    import java.util.List;

    /**
     * 具体的创建者
    * 生产产品
    */
public class IDCardFactory extends Factory {
    private List owners = new ArrayList();
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }
    public List getOwners(){
        return owners;
    }
}
