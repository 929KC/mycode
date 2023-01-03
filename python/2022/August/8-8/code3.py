#人生重开模拟器
import random

print("|--------------------------------|")
print("|--------------------------------|")
print("|--------------------------------|")
print("|------花开重见日,人无再少年--------|")
print("|------欢饮来到,人生重开模拟器-------|")
print("|--------------------------------|")
print("|--------------------------------|")
print("|--------------------------------|")

#设置人物初始属性
while True:
    print("请设定初始属性(可分配属性点数为20):")
    face = int(input("设定颜值(1~20):"))
    home = int(input("设定家境(1~20):"))
    iq = int(input("设定智商(1~20):"))
    strong = int(input("设计体质(1~20):"))
    if face < 1 or face > 20:
        print("颜值设置有误")
        continue
    if home < 1 or home > 20:
        print("家境设置有误")
        continue
    if strong < 1 or strong > 20:
       print("strong设置有误")
       continue
    if iq < 1 or iq > 20:
        print("iq设置有误")
        continue
    if (iq+home+strong+face) > 20:
        print("属性点分配有误")
        continue
    print("人物属性值初始化成功")
    print(f"颜值:{face},体质:{strong},iq:{iq},家境；{home}。")
    break

#设置性别
point = random.randint(1,6)#[1,6]
if point % 2 ==1:
    gender = "boy"
    print("你是一个男孩子")
else:
    gender = "girl"
    print("你是一个女孩子")