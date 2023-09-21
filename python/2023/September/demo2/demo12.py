money = 10
bottle_caps = 0 #啤酒盖
empty_bottles = 0 #空瓶数
total_beers = 0#可以喝的啤酒数
while money >= 2:
    beers_purchased = money // 2
    total_beers += beers_purchased
    money -= beers_purchased * 2
    bottle_caps += beers_purchased
    empty_bottles += beers_purchased
    beers_from_caps = bottle_caps // 4
    total_beers += beers_from_caps
    bottle_caps -= beers_from_caps * 4
    beers_from_empty_bottles = empty_bottles // 2
    total_beers += beers_from_empty_bottles
    empty_bottles -= beers_from_empty_bottles * 2
print("总共可以喝到的啤酒瓶数:", total_beers)
