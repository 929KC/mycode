# 输入利润（万元）
profit = float(input("请输入利润（万元）："))
bonus = 0
if profit <= 10:
    bonus = profit * 0.1
elif profit <= 20:
    bonus = 10 * 0.1 + (profit - 10) * 0.075
elif profit <= 40:
    bonus = 10 * 0.1 + 10 * 0.075 + (profit - 20) * 0.05
elif profit <= 60:
    bonus = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + (profit - 40) * 0.03
elif profit <= 100:
    bonus = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + (profit - 60) * 0.015
else:
    bonus = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + 40 * 0.015 + (profit - 100) * 0.01
print(f"员工应得奖金：{bonus:.2f} 万元")
