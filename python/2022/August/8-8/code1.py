print(12+12)
print(12*12)
print(3/2)
print(12-12)

print((67.5+89.0+12.9+32.2)/4)
avg = (67.5+89.0+12.9+32.2)/4
total = (67.5-avg)**2+(89.0-avg)**2+(12.9-avg)**2+(32.2-avg)**2
result = total/3
print(result)
print("-------------------")
a = 90
b= 90.0
c = 90.9012
d = "q"
e = "avg"
f = True
g = False
print(type(a))
print(type(b))
print(type(c))
print(type(d))
print(type(e))
print(type(f))
print(type(g))

"""
py学习第一天
"""
num = 10
print(f'num = {num}')
print(f'num = {num}')
print("-------------")
num = 0
#num = input("请输入一个数:")
#print(f'你输入的数:{num}')
"""
a = input("请输入第一个数:")
b = input("请输入第二个数:")
c = input("请输入第三个数:")
d = input("请输入第四个数:")
a = int (a)
b = int(b)
c = int(c)
d = int(d)
avg = (a+b+c+d)/4
print(f' num = {avg}')
"""
print(7%2)
print(7//2)

str1 = "hello"
str2 = "world"
str3 = "hello"
str4 = "world"

print(str1 == str2)
print(str1 == str3)
print(str4 == str2)

a = 10
b = 20
c = 30
print(a>b and b>c)
print(a<b or b<c)
print(not a>b)
print(not c<b)

#多元赋值
a = 10
b = 20
tmp = a
a = b
b = tmp
print(f'a={a}')
print(f'b={b}')

if 12>10:
    print("Hello World")