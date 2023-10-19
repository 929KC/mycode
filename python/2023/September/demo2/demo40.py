def sum_even_numbers():
    total = 0
    for i in range(1, 101):
        if i % 2 == 0:  # 检查是否为偶数
            total += i
    return total

result = sum_even_numbers()
print("1到100中偶数之和为:", result)
