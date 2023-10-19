users = {}  # 存储用户信息的字典


def register_user():
    username = input("请输入用户名: ")
    password = input("请输入密码: ")
    users[username] = password
    print("注册成功！")


def login_user():
    username = input("请输入用户名: ")
    password = input("请输入密码: ")
    if username in users and users[username] == password:
        print("登录成功！")
    else:
        print("用户名或密码错误！")


def logout_user():
    username = input("请输入要注销的用户名: ")
    if username in users:
        del users[username]
        print("注销成功！")
    else:
        print("该用户不存在！")


def show_user_info():
    username = input("请输入要查询的用户名: ")
    if username in users:
        print("用户名: ", username)
        print("密码: ", users[username])
    else:
        print("该用户不存在！")


def exit_system():
    print("退出系统")
    exit(0)


# 主程序
while True:
    print("1. 注册新用户")
    print("2. 用户登录")
    print("3. 注销用户")
    print("4. 显示用户信息")
    print("5. 退出系统")
    choice = input("请输入要执行的操作编号: ")
    if choice == "1":
        register_user()
    elif choice == "2":
        login_user()
    elif choice == "3":
        logout_user()
    elif choice == "4":
        show_user_info()
    elif choice == "5":
        exit_system()
    else:
        print("无效的操作编号，请重新输入！")
