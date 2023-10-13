a = "我叫张三，今年 18 岁，英文名叫 tom"
result = a.isidentifier()
print(f"a 是否是合法的标识符: {result}")
# 2. 使用 isspace() 判断 b 是否全部由空白字符组成
b = "人生苦短，我学 Python！"
result = b.isspace()
print(f"b 是否全部由空白字符组成: {result}")
# 3. 使用 isalpha() 判断 c 是否全部由字母组成
c = "HelloWorld"
result = c.isalpha()
print(f"c 是否全部由字母组成: {result}")
# 4. 使用 isdecimal() 判断 a 是否全部由十进制数字组成
result = a.isdecimal()
print(f"a 是否全部由十进制数字组成: {result}")
# 5. 使用 isnumeric() 判断 d 是否全部由数字组成
d = "520jack"
result = d.isnumeric()
print(f"d 是否全部由数字组成: {result}")
# 6. 使用 isalnum() 判断 d 是否全部由字母和数字组成
result = d.isalnum()
print(f"d 是否全部由字母和数字组成: {result}")
