
height = float(input("请输入身高（单位：米）："))
weight = float(input("请输入体重（单位：千克）："))
bmi = weight / (height ** 2)
if bmi < 18.5:
    category = "过轻"
elif 18.5 <= bmi <= 23.9:
    category = "正常"
elif 24 <= bmi <= 27:
    category = "过重"
elif 28 <= bmi <= 32:
    category = "肥胖"
else:
    category = "非常肥胖"
print(f"您的BMI值为：{bmi:.2f}")
print(f"您的BMI分类是：{category}")
