
def calSum(num1, num2):
    return num1+num2
ret = calSum(12,12)
print(calSum(12,12))
print(f'ret={ret}')
def printF():
    print("Hello World")
printF()


def getPoint():
    x = 90
    y = 45
    return x,y
a,b = getPoint()
print(a)
print(b)

def getPoint2():
    x = 90
    y = 23
    return x,y
_,a = getPoint2()
print(a)


num = 12
def test():
   # num = 78
   global num
   num = 78
   print(f'局部变量:{num}')#num如果在函数中没有找到,就向函数外查找,函数外没有的话,就会报错
print(f'全局变量:{num}')
test()

for i in range(1,10):
    print(f'函数内部i = {i}')
print(f'函数外部:i = {i}')

def test2(x,y,debug=False):
    if debug:
        print(f'x={x},y={y}')
    return x+y
print(test2(12,12))
#print(test2(12,45,True))

