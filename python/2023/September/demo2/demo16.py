# 获取用户输入的密码
password = input("请输入6位数字密码: ")

# 确保密码是6位数字
if len(password) != 6 or not password.isdigit():
    print("密码必须是6位数字")
else:
    # 计算每个数字的ASCII值并累加求和
    ascii_sum = sum(ord(char) for char in password)
    # 将每个数字的ASCII值按照从前往后的顺序进行拼接
    concat_result = ''.join(str(ord(char)) for char in password)
    # 将拼接后的结果进行反转
    reversed_result = concat_result[::-1]
    # 将反转的结果与累加的结果相加，得到加密后的密码
    encrypted_password = str(ascii_sum + int(reversed_result))
    print("加密后的密码:", encrypted_password)
