# num = int(input("请输入一个数:"))
# if num%2==0:
#     print("你输入的" ,num,"是一个偶数")
# else:
#     print("你输入",num,"是一个奇数")

# num = int(input("请输入一个整数:"))
# if num>=90 and num<=100:
#     print("A")
# elif num>=80:
#     print("B")
# elif num>=70:
#     print("C")
# elif num>=60:
#     print("D")
# else:
#     print("E")
MEMBER="会员"
NOMEMBER="非会员"
card = input("请出示你的卡:")
num = input("你的消费总额:")
if card==MEMBER:
    if num>=200:
        print("8折"+num*.08)
    elif num>=100:
        print("9折"+num*0.9)
    else:
        print("不打折")
elif card==NOMEMBER:
    if num>=200:
        print("9.5折"+num*0.95)
    else:
      print("不打折")