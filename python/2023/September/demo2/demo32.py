# 1. 使用 {} 创建集合 s 并输出
s = {1, 2, 3, 4, 5, 6, 7, 8}
print("1. 使用 {} 创建的集合 s:", s)
# 2. 使用内置函数 set() 创建集合 s 并输出
s = set([1, 2, 3, 4, 5, 6, 7, 8])
print("2. 使用 set() 创建的集合 s:", s)
# 3. 将列表 [1, 5, 3, 1, 7, 2, 8, 9] 转换成新集合并输出
new_set1 = set([1, 5, 3, 1, 7, 2, 8, 9])
print("3. 从列表创建的新集合:", new_set1)
# 4. 将元组 ('tom', 'jack', 'rose') 转换成新集合并输出
new_set2 = set(('tom', 'jack', 'rose'))
print("4. 从元组创建的新集合:", new_set2)
# 5. 使用 add() 和 update() 方法添加新的元素到集合 s 中并输出
s.add(9)  # 使用 add() 方法添加单个元素
s.update([10, 11, 12])  # 使用 update() 方法添加多个元素
print("5. 添加新元素后的集合 s:", s)
# 6. 使用 discard() 和 remove() 方法删除集合 s 中一个指定元素；pop() 方法删除集合 s 中任意元素；使用 clear() 清空集合所有元素
s.discard(11)  # 使用 discard() 方法删除元素，如果元素不存在也不会报错
s.remove(10)  # 使用 remove() 方法删除元素，如果元素不存在会报错
popped_element = s.pop()  # 使用 pop() 方法删除集合中任意元素，并将其返回
s.clear()  # 使用 clear() 方法清空集合
print("6. 删除和清空操作后的集合 s:", s)
