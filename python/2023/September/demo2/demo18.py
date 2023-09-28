correct_username = "root"
correct_password = "2222"
attempts = 0
while attempts < 3:
    username = input("请输入用户名: ")
    password = input("请输入密码: ")
    if username == correct_username and password == correct_password:
        print("登录成功")
        break
    else:
        attempts += 1
        remaining_attempts = 3 - attempts
        if remaining_attempts > 0:
            print("用户名或密码错误，您还有{}次机会".format(remaining_attempts))
        else:
            print("输入错误次数过多，请稍后再试")
