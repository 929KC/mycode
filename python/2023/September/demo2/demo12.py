# 初始化变量
money = 10  # 初始金额
bottles = money // 2  # 初始可以购买的啤酒瓶数
caps = bottles  # 初始瓶盖数
empty_bottles = bottles  # 初始空瓶子数

while caps >= 4 or empty_bottles >= 2:
    # 使用瓶盖兑换啤酒
    exchanged_beers_caps = caps // 4
    bottles += exchanged_beers_caps
    caps -= exchanged_beers_caps * 4

    # 使用空瓶子兑换啤酒
    exchanged_beers_bottles = empty_bottles // 2
    bottles += exchanged_beers_bottles
    empty_bottles -= exchanged_beers_bottles * 2

print("总共可以喝", bottles, "瓶啤酒")
