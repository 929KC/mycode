package org.example.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 管理联系人
 */
public class AddressBook implements Serializable{
    /**
     * 序列化id
     */
    private static final long serialVersionUID = -8793508365036871683L;
    /**
     * 文件路径
     */
    private String filePath;
    /**
     * 保存联系人的列表
     */
    private List<Contact> contacts ;

    public AddressBook(String path) {
        this.contacts = new ArrayList<Contact>();
        this.filePath = path;
    }

    /**
     * 添加联系人
     *
     * @param
     * @return
     */

    public boolean addContact(Contact contact) {
        String phoneNum = contact.getPhoneNum();
        String qq = contact.getQq();
        String email = contact.getEmail();
        //正则表达式博客:https://blog.csdn.net/itbrand/article/details/109239620
        if (!phoneNum.matches("^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\\d{8}$")) {
            System.out.println("手机号格式不正确!");
            return false;
        }
        if (!qq.matches("^[1-9]\\d{4,11}")) {
            System.out.println("qq格式不对!");
            return false;
        }
        if (!email.matches("^\\w+?@.+?\\.\\w+$")) {
            System.out.println("邮箱格式不匹配!");
            return false;
        }
        contacts.add(contact);
        return true;
    }

    /**
     * 根据条件查询（模糊查询）
     *
     * @param flag 查询方式：1-按姓名 2-按手机号
     * @param key  关键字
     * @return
     */
    public List<Contact> findByCondition(int flag, String key) {
        // 声明一个临时变量存储查询到的符合条件的数据
        ArrayList<Contact> temp = new ArrayList<Contact>();
        // 对联系人遍历
        for (Contact c : contacts) {
            if (flag == 1) {
                // 按姓名
                if (c.getName().contains(key)) {
                    // 判断联系人姓名中是否包含指定的查询关键字
                    temp.add(c);
                }
            } else if (flag == 2) {
                // 按手机号
                if (c.getPhoneNum().contains(key)) {
                    temp.add(c);
                }
            } else {
                contacts = contacts;
                break;
            }
        }
        return temp;
    }

    /**
     * 查询所有（分页）
     *
     * @param pageNow  当前数据的页码数
     * @param pageSize 每页数据的最大条目
     * @return 放回当前页的数据集
     */
    public List<Contact> findAll(int pageNow, int pageSize) {
        int from = (pageNow - 1) * pageSize;
        int to = pageNow * pageSize;
        // 如果集合中没数据时返回null
        if (contacts.size() < 1) {
            return null;
        }
        //开始位置不能等于总数据条数(越界)
        if(from >= contacts.size()) {
            return null;
        }
        // 结尾的位置不能超过数据总条数
        if (to > contacts.size()) {
            to = contacts.size();
        }
        return contacts.subList(from, to);
    }

    /**
     * 根据编号删除联系人
     * @param num
     * @return
     */
    public boolean delContact(int num) {
        Contact target = null;
        boolean result = false;
        for (Contact c : contacts) {
            if(c.getNum() == num) {
                target = c;
                result = contacts.remove(target);
                //更新联系人
                saveToFile();
                break;
            }
        }
        if(Objects.isNull(target)) {
            System.out.println("未找到目标联系人");
            return result;
        }
        return result;
    }
    public List<Contact> getContacts() {
        return contacts;
    }
    public void saveToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
            outputStream.writeObject(contacts);
            System.out.println("通讯录已成功保存到文件 " + filePath);
        } catch (IOException e) {
            System.err.println("保存通讯录时发生错误: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            contacts = (List<Contact>) inputStream.readObject();
            System.out.println("从文件 " + filePath + " 加载了通讯录");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("加载通讯录时发生错误: " + e.getMessage());
        }
    }
}
