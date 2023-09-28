# 创建列表s1、s2和s3
s1 = ['春眠不觉晓', 'python不得了', '也来爬数据', '好评知多少']
s2 = ['10', '20', '30', '40', '20']
s3 = ['10', '21', '3', '4', 'f', 'a', 'c']

# 1. 遍历列表s1并输出
for item in s1:
    print(item)


# 2. 统计s2中20出现的次数；统计s2中所有数值的和
count_20 = s2.count('20')
sum_values = sum(map(int, s2))  # 将字符串转换为整数再求和

print("20出现的次数:", count_20)
print("所有数值的和:", sum_values)

# 3. 将50添加到s2的末尾；将s2添加到s1的末尾
s2.append('50')
s1.extend(s2)

# 4. 在s2的任意位置插入元素100；将s2插入到s1的任意位置
s2.insert(2, '100')  # 在索引2的位置插入100
s1.insert(1, s2)  # 在索引1的位置插入s2整个列表
print(s1)
# 5. 将s1中的'python不得了'修改为'java不得了'
s1[1] = 'java不得了'
print(s1)
# 6. 使用Remove()、Pop()、切片、Clear()、删除s2中的任意元素
s2.remove('30')  # 删除第一个出现的'30'
popped_value = s2.pop(1)  # 删除索引1处的元素并返回
del s2[1:3]  # 使用切片删除索引1到2处的元素
s2.clear()  # 清空s2列表


# 7. 将s3进行升序排列并输出；将s3进行降序排列并输出；分别使用sort()和sorted()
s3.sort()
print("升序",s3)
print("降序",sorted(s3,reverse=True))