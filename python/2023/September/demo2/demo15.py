#
# count = 0
# while 1:
#     password = input("请输入你的密码:")
#     count+=1
#     if password=="8888":
#         print("你的正确")
#         break
#     else:
#         print("你的密码错误")
#     print('你已经输入了% d次,剩余% d' %(count,3-count))
#     if count==0:
#         print("十五分钟后输入")
#         break


for i  in range(1,51,1):
    if i%5==0:
        print(i)
    else:
       continue