str1 = ['天苍苍', '野茫茫', '我要把你追到手', 'I', 'Love', 'You', '!']
str2 = ['赵丽颖']
str3 = [15, 21, 3, 8, 9, 39, 42, 13]
# 正向输出 "天苍苍，野茫茫"
print(str1[0] + '，' + str1[1])
# 逆向输出 'I', 'Love', 'You', '!'
print(str1[-5:-1][::-1])

# 使用切片把英文部分输出
english_part = str1[3:7]
print(english_part)
# 重复输出 str1
str1_repeat = str1 * 2
print(str1_repeat)
# 合并 str1 和 str2 到 str4
str4 = str1 + str2
# 输出合并后的 str4
print(str4)
# 检查王一博是否在 str1 中
is_in_str1 = '王一博' in str1
print('王一博是否在 str1 中:', is_in_str1)
# 检查王一博是否在 str2 中
is_in_str2 = '王一博' in str2
print('王一博是否在 str2 中:', is_in_str2)
# 求 str1 的长度
len_str1 = len(str1)
print('str1 的长度:', len_str1)
# 求 str2 的长度
len_str2 = len(str2)
print('str2 的长度:', len_str2)
# 求 str3 中的最大值
max_value = max(str3)
print('str3 中的最大值:', max_value)
# 求 str3 中的最小值
min_value = min(str3)
print('str3 中的最小值:', min_value)

# 创建一个代表刮刮乐的数组
scratch_card = ["谢谢惠顾", "一等奖", "三等奖", "谢谢惠顾", "谢谢惠顾", "三等奖", "二等奖", "谢谢惠顾"]

# 提示用户输入兑奖区的编号（1~8）
try:
    scratch_area = int(input("请输入兑奖区的编号（1~8）："))

    # 检查用户输入的编号是否在有效范围内
    if 1 <= scratch_area <= 8:
        # 获取兑奖信息并输出
        prize = scratch_card[scratch_area - 1]
        print("兑奖区{}的兑奖信息是：{}".format(scratch_area, prize))
    else:
        print("输入的位置不合规")
except ValueError:
    print("请输入有效的编号（1~8）")
