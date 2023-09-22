#
# num = input("请输入一个4位整数：")
# if len(num) != 4 or not num.isdigit():
#     print("请输入有效的4位整数。")
# else:
#     if num == num[::-1]:
#         print(f"{num} 是一个回文数。")
#     else:
#         print(f"{num} 不是一个回文数。")


sum=0

for i in range(100):

    if(i%10):

        continue

    sum = sum + i

print(sum)