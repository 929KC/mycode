package com.kc.shoping.mapper.impl;

import com.kc.shoping.mapper.ProductMapper;
import com.kc.shoping.model.Product;
import com.kc.shoping.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 929KC
 * @date 2022/12/13 18:01
 * @description:
 */
public class productImpl implements ProductMapper {

    @Override
    public List<Product> queryProducts() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Product> list = null;
        try {
            String sql = "select *from product;";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            list = new ArrayList<>();
            while (rs.next()) {
                Product procuct = new Product(rs.getInt("productId"),rs.getInt("categoryId"),rs.getString("productName"),rs.getFloat("price"),rs.getString("remark"),rs.getString("registerTime"));
                list.add(procuct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, rs);
        }
        return list;
    }

    @Override
    public Product queryProductLike(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        Product procuct = null;
        try {
            String sql = "select *from product where productName like ?;";
            connection = DBUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1,"%"+name);
            rs = statement.executeQuery();
            while (rs.next()) {
                procuct = new Product(rs.getInt("productId"),rs.getInt("categoryId"),rs.getString("productName"),rs.getFloat("price"),rs.getString("remark"),rs.getString("registerTime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, statement, rs);
        }
        return procuct;
    }
}
