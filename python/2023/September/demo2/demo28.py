my_dict = {'key1': 'value1', 'key2': 'value2', 'key3': 'value3'}
print(my_dict)
my_dict = dict(key1='value1', key2='value2', key3='value3')
print(my_dict)
lst1 = ['小花', '小明']
lst2 = [96, 87]
my_dict = dict(zip(lst1, lst2))
print(my_dict)
my_dict = {i: i * 2 for i in range(5)}
print(my_dict)
my_dict = {'key1': 'value1', 'key2': 'value2', 'key3': 'value3'}
my_dict.clear()
print(my_dict)  # 输出：{}
