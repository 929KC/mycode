def calculate_product():
    result = 1
    for i in range(20, 2, -1):
        result *= i
    return result

product = calculate_product()
print("20*19*18*...*3的结果为:", product)
