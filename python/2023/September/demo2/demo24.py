def find_total_fish():
    x = 1  # 初始假设鱼的总数为1
    while True:
        if x % 5 == 1:  # A拿走后余1
            y = x - 1 - x // 5
            if y % 5 == 1:  # B拿走后余1
                z = y - 1 - y // 5
                if z % 5 == 1:  # C拿走后余1
                    w = z - 1 - z // 5
                    if w % 5 == 1:  # D拿走后余1
                        u = w - 1 - w // 5
                        if u % 5 == 1:  # E拿走后余1
                            return x  # 找到合适的鱼数
        x += 1  # 没找到合适的鱼数，继续尝试下一个

total_fish = find_total_fish()
print("07-黄茂荣-合伙至少捕了", total_fish, "条鱼")
