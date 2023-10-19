def calculate_discount(money):
    total = sum(money)  # 计算商品的合计金额
    discount = total  # 默认折扣为合计金额
    if total >= 3000:
        discount *= 0.6  # 满3000可享受6折优惠
    elif total >= 2000:
        discount *= 0.7  # 满2000可享受7折优惠
    elif total >= 1000:
        discount *= 0.8  # 满1000可享受8折优惠
    elif total >= 500:
        discount *= 0.9  # 满500可享受9折优惠
    return total, discount
money = [1000, 800, 1200, 500]  # 商品金额列表
total_amount, discount_amount = calculate_discount(money)
print("商品的合计金额为:", total_amount)
print("折扣后的金额为:", discount_amount)