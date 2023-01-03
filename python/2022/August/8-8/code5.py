"""
alist = []
alist = list()
print(type(alist))

alist = [1,"java","C++",True,9004]
at = ()
bt = tuple()
print(type(at))
print(type(bt))
a = {}
b = dict()
print(type(a))
print(type(b))
"""



"""
blist = [1,2,3,5,6,76,7]
print(alist+blist)
alist.extend(blist)
print(alist)

"""
"""
alist.append("hello")
alist.insert(1,"world")
print(1 in alist)
print(alist.index(1))
print(alist.pop())
print(alist.pop(1))
print(alist.remove(1))
print(alist)
"""
"""
print(alist)
print(alist[0])
print(alist[len(alist)-1])
print(alist[1:3])
print("===========")
print(alist[1:])
print(alist[:-1])
print(alist[:])
print(alist[::3])
print(len(alist))
"""

"""
for elem in alist:
    print(elem)
for elem in range(len(alist)):
    print(alist[elem])

"""



student = {
    "id":1,
    "age":19,
    "name":"叶秋涵",
    "address":"湖南"
}
student["address"] = "长沙"
#print(student)
#print("id" in student)
#print(student["id"])

for key in student:
    print(key,student[key])

print(student.keys())
print(student.values())
print(student.items())
print(hash(False))

