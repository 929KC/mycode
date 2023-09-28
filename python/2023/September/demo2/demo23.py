# 创建一个空的好友列表
friends = []

while True:
    print("好友管理系统功能菜单:")
    print("1. 添加好友")
    print("2. 删除好友")
    print("3. 备注好友")
    print("4. 展示好友")
    print("5. 退出")

    choice = input("请输入您的选项: ")

    if choice == "1":
        # 添加好友
        friend_name = input("请输入要添加的好友：")
        friends.append(friend_name)
        print("好友添加成功！")

    elif choice == "2":
        # 删除好友
        if not friends:
            print("好友列表为空")
        else:
            friend_name = input("请输入删除好友姓名：")
            if friend_name in friends:
                friends.remove(friend_name)
                print("删除成功！")
            else:
                print("好友不存在")

    elif choice == "3":
        # 备注好友
        if not friends:
            print("好友列表为空")
        else:
            old_name = input("请输入要修改的好友姓名：")
            if old_name in friends:
                index = friends.index(old_name)
                new_name = input("请输入修改后的好友姓名：")
                friends[index] = new_name
                print("备注成功！")
            else:
                print("好友不存在")

    elif choice == "4":
        # 展示好友
        if not friends:
            print("好友列表为空")
        else:
            print("好友列表:")
            for friend in friends:
                print(friend)

    elif choice == "5":
        # 退出
        print("退出好友管理系统。")
        break

    else:
        print("无效选项，请重新输入。")
