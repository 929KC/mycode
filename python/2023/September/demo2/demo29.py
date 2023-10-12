scores = {'张三': 100, '李四': 94, '王五': 98, 'jack': 80, 'tom': 90}
keys = scores.keys()
print("1. 所有的 key:", keys)
values = scores.values()
print("2. 所有的 value:", values)
items = scores.items()
print("3. 所有的 key, value 对:", items)
print("4. 遍历字典 scores 并输出所有 key, value 对:")
for key, value in scores.items():
    print(key, value)
value_100 = scores.get('张三')
print("5. 分值为 100 的值:", value_100)
