# 从用户输入获取十进制数字
decimal_number = int(input("请输入一个十进制数字："))

# 转换为二进制、八进制和十六进制，并输出结果
binary_number = bin(decimal_number)
octal_number = oct(decimal_number)
hexadecimal_number = hex(decimal_number)

print(f"十进制数字 {decimal_number} 的二进制表示为：{binary_number}")
print(f"十进制数字 {decimal_number} 的八进制表示为：{octal_number}")
print(f"十进制数字 {decimal_number} 的十六进制表示为：{hexadecimal_number}")
