from code1 import num

a = 20
b = 56
c = 45
if a > b:
    print(f'a={a}')
elif c > b:
    print(f'b={b}')
else:
    print("Hello World")
"""
    choice = input("输入1表示认真学习,输入二表示躺平摆烂:")#输入的为字符串
    if choice == "1":
        print("你会找到好工作")
    elif choice == "2":
        print("你可能毕业就是失业")
    else:
        print("上街卖红薯")

    a = input("请输入一个整数:")
    if a =="1":
        print("Hello")
        print("World")
    b = input("请输入一个整数:")
    if b == "1":
        print("Hello")
    print("World")

    d = input("请输入一个整数:")
    if d != 1:
        pass
    else:
        print(f'd={d}')
"""

"""
sum = 0
num = 1
while num <= 100:
    sum += num
    num +=1
print(sum)

num = 1
sum = 0
while num <= 5:
    factorResult = 1
    i = 1
    while i <= num:
        factorResult *=i
        i += 1
    sum+=factorResult
    num +=1

print(sum)



for i in range(1,11):
    print(i)
for i in range(2,12,2):
    print(i)

"""


for i in range(1,11):
    if i == 3:
        continue
    print(f'num={i}')

for i in range(1,11):
    if i == 3:
        break
    print(f'n'
          f'um={i}')
