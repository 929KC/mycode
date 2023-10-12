# 给定字典 scores
scores = {'张三': 100, '李四': 94, '王五': 98, 'jack': 80, 'tom': 90}
scores['rose'] = 95
scores['jack'] = 100
if '张三' in scores:
    del scores['张三']
is_in_scores = '张三' in scores
print("更新后的字典 scores:", scores)
print("是否 '张三' 在字典中:", is_in_scores)
