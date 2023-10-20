def calculate_average(numbers):
    # 检查列表是否为空
    if len(numbers) == 0:
        return None
    total = sum(numbers)
    average = total / len(numbers)
    return average
my_numbers = [5, 10, 15, 20, 25]
result = calculate_average(my_numbers)
if result is not None:
    print(f"平均值是 {result}")
else:
    print("列表为空，无法计算平均值。")
