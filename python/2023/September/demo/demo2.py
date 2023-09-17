# 个人信息
name = "黄茂荣"
gender = "男"
age = 25
height = 175.5  # 单位：厘米
weight = 68.5  # 单位：公斤

# 学生信息
student_id = "2023001"

# 爱好
hobbies = ["篮球", "阅读", "旅行"]

# 身份证号（常量）
ID_CARD = "123456789012345678"

# 输出自我介绍
print("大家好，我是{}，{}，今年{}岁，身高{}cm，体重{}kg。".format(name, gender, age, height, weight))
print("我是一名学生，学号是{}，平时喜欢{}。".format(student_id, "、".join(hobbies)))
print("我的身份证号是{}。".format(ID_CARD))
