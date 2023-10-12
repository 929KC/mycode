# 创建一个空的个人通讯录字典
contacts = {}

while True:
    print("个人通讯录操作选项:")
    print("1. 增加联系人")
    print("2. 删除联系人")
    print("3. 修改联系人")
    print("4. 显示所有联系人")
    print("5. 查看联系人")
    print("6. 退出")

    choice = input("请选择操作 (1/2/3/4/5/6): ")

    if choice == '1':
        name = input("请输入联系人姓名: ")
        phone = input("请输入联系人电话号码: ")
        contacts[name] = phone
        print("联系人已添加")

    elif choice == '2':
        name = input("请输入要删除的联系人姓名: ")
        if name in contacts:
            del contacts[name]
            print("联系人已删除")
        else:
            print("联系人不存在")

    elif choice == '3':
        name = input("请输入要修改的联系人姓名: ")
        if name in contacts:
            phone = input("请输入新的电话号码: ")
            contacts[name] = phone
            print("联系人已修改")
        else:
            print("联系人不存在")

    elif choice == '4':
        print("所有联系人:")
        for name, phone in contacts.items():
            print(f"{name}: {phone}")

    elif choice == '5':
        name = input("请输入要查看的联系人姓名: ")
        if name in contacts:
            print(f"{name}: {contacts[name]}")
        else:
            print("联系人不存在")

    elif choice == '6':
        break

    else:
        print("无效的选择，请重新选择。")

print("通讯录已退出。")
