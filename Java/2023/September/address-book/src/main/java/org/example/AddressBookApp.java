package org.example;

import org.example.model.AddressBook;
import org.example.model.Contact;

import java.util.List;
import java.util.Scanner;

public class AddressBookApp {
    private static final int CONTACT = 1;
    private static final int PHONE = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AddressBook addressBook = new AddressBook("src/main/resources/contacts.bat");
        // 从文件加载通讯录
        addressBook.loadFromFile();
        while (true) {
            System.out.println("===== 通讯录应用程序 =====");
            System.out.println("1. 添加联系人");
            System.out.println("2. 按姓名查询联系人");
            System.out.println("3. 按手机号查询联系人");
            System.out.println("4. 显示联系人列表（分页）");
            System.out.println("5. 删除联系人");
            System.out.println("6. 保存通讯录并退出");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 消耗换行符
            switch (choice) {
                case 1:
                    // 添加联系人
                    System.out.print("请输入联系人姓名: ");
                    String name = scanner.nextLine();
                    System.out.print("请输入联系人电话号码: ");
                    String phoneNum = scanner.nextLine();
                    System.out.print("请输入联系人QQ: ");
                    String qq = scanner.nextLine();
                    System.out.print("请输入联系人邮箱: ");
                    String email = scanner.nextLine();
                    Contact contact = Contact.builder().name(name).phoneNum(phoneNum).email(email).qq(qq).build();
                    boolean added = addressBook.addContact(contact);
                    if (added) {
                        System.out.println("联系人已添加.");
                    } else {
                        System.out.println("联系人添加失败.");
                    }
                    break;
                case 2:
                    // 按姓名查询联系人
                    System.out.print("请输入要查询的姓名关键字: ");
                    String nameKeyword = scanner.nextLine();
                    List<Contact> nameResults = addressBook.findByCondition(CONTACT, nameKeyword);
                    displayContacts(nameResults);
                    break;
                case 3:
                    // 按手机号查询联系人
                    System.out.print("请输入要查询的手机号关键字: ");
                    String phoneKeyword = scanner.nextLine();
                    List<Contact> phoneResults = addressBook.findByCondition(PHONE, phoneKeyword);
                    displayContacts(phoneResults);
                    break;
                case 4:
                    // 分页显示联系人列表
                    System.out.print("请输入要显示的页码: ");
                    int pageNow = scanner.nextInt();
                    System.out.print("请输入每页的条目数: ");
                    int pageSize = scanner.nextInt();
                    List<Contact> pageResults = addressBook.findAll(pageNow, pageSize);
                    displayContacts(pageResults);
                    break;
                case 5:
                    // 删除联系人
                    System.out.print("请输入要删除的联系人编号: ");
                    int numToDelete = scanner.nextInt();
                    scanner.nextLine(); // 消耗换行符
                    addressBook.delContact(numToDelete);
                    break;
                case 6:
                    // 保存通讯录并退出
                    addressBook.saveToFile();
                    System.out.println("通讯录已保存，程序退出。");
                    System.exit(0);
                default:
                    System.out.println("无效的选项，请重新选择。");
            }
        }
    }

    private static void displayContacts(List<Contact> contacts) {
        if (contacts == null || contacts.isEmpty()) {
            System.out.println("未找到符合条件的联系人.");
            return;
        }
        for (Contact c : contacts) {
            displayContact(c);
        }
    }

    private static void displayContact(Contact contact) {
        System.out.println("联系人编号: " + contact.getNum());
        System.out.println("姓名: " + contact.getName());
        System.out.println("电话号码: " + contact.getPhoneNum());
        System.out.println("QQ: " + contact.getQq());
        System.out.println("邮箱: " + contact.getEmail());
        System.out.println("-----------------------------");
    }
}
