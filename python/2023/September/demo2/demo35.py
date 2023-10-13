# 使用占位符和 format 方式实现字符串格式化
# 1. 使用占位符格式化输出“我叫 xxx，今年 xx 岁”
name = "Alice"
age = 30
formatted_string = "我叫 %s，今年 %d 岁" % (name, age)
print(formatted_string)
# 2. 使用 format 方式格式化输出 192.168.0.100:8888
ip = "192.168.0.100"
port = 8888
formatted_string = "{}:{}".format(ip, port)
print(formatted_string)
# 3. 使用 format 方式格式化将 3.1415925 输出为 3.14
number = 3.1415925
formatted_string = "{:.2f}".format(number)
print(formatted_string)
# 4. 使用 format 方式格式化输出“我叫 xxx，今年 xx 岁
name = "Bob"
age = 25
formatted_string = "我叫 {}，今年 {} 岁".format(name, age)
print(formatted_string)
