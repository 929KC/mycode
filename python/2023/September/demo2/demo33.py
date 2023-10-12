# 给定集合 s1, s2, 和 s3
s1 = {10, 20, 30, 40, 50, 60}
s2 = {30, 40, 20, 10}
s3 = {10, 20, 30, 40}
# 1. 判断集合 s2\s3 是否相等；s2 是否是 s1 的子集
is_equal = s2 == s3  # 判断 s2\s3 是否相等
is_subset = s2.issubset(s1)  # 判断 s2 是否是 s1 的子集
print("1. s2\\s3 是否相等:", is_equal)
print("   s2 是否是 s1 的子集:", is_subset)
# 2. 完成 s1\s2 的交集操作；完成 s1\s2 的并操作；完成 s1\s2 的差集操作；完成 s1\s2 的对称差集操作
intersection = s1.intersection(s2)  # s1\s2 的交集
union = s1.union(s2)  # s1\s2 的并集
difference = s1.difference(s2)  # s1\s2 的差集
symmetric_difference = s1.symmetric_difference(s2)  # s1\s2 的对称差集
print("2. s1\\s2 的交集:", intersection)
print("   s1\\s2 的并集:", union)
print("   s1\\s2 的差集:", difference)
print("   s1\\s2 的对称差集:", symmetric_difference)
