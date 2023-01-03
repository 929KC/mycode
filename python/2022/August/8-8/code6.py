#f = open("E:/test.txt",'r')
#f.write("叶秋涵")
#f.write("Hello World")
#result = f.read(14)
#print(result)
#for line in f:
 #   print(f'line={line}',end="")
# lines = f.readlines()
# print(lines)
# f.close()


with open("E:/test.txt",'r') as f:
    lines = f.readlines()
    print(lines,end="")
