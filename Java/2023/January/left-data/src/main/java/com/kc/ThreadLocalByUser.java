package com.kc;
/**
 * 用户实体类
 */
class User {
    public User(String name) {
        this.name = name;
    }
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
/**
 * 用户信息存储类
 */
class UserStorage {
    // 用户信息
    public static ThreadLocal<User> USER = new ThreadLocal();

    /**
     * 存储用户信息
     * @param user 用户数据
     */
    public static void setUser(User user) {
        USER.set(user);
    }
}
/**
 * 订单类
 */
class OrderSystem {
    /**
     * 订单添加方法
     */
    public void add() {
        // 得到用户信息
        User user = UserStorage.USER.get();
        // 业务处理代码（忽略）...
        System.out.println(String.format("订单系统收到用户：%s 的请求。",
                user.getName()));
    }
}
class RepertorySystem {
    /**
     * 减库存方法
     */
    public void decrement() {
        // 得到用户信息
        User user = UserStorage.USER.get();
        // 业务处理代码（忽略）...
        System.out.println(String.format("仓储系统收到用户：%s 的请求。",
                user.getName()));
    }
}
public class ThreadLocalByUser {
    public static void main(String[] args) {
        // 初始化用户信息
        User user = new User("Java");
        // 将 User 对象存储在 ThreadLocal 中
        UserStorage.setUser(user);
        // 调用订单系统
        OrderSystem orderSystem = new OrderSystem();
        // 添加订单（方法内获取用户信息）
        orderSystem.add();
        // 调用仓储系统
        RepertorySystem repertory = new RepertorySystem();
        // 减库存（方法内获取用户信息）
        repertory.decrement();
    }
}