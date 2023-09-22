money = 10
beers = money // 2
bottles = 0
count = 0
caps = 0
while beers > 0:
    caps = caps+beers
    bottles = bottles+beers
    count = count+beers
    print("这次喝了% d瓶啤酒,总计% d 瓶啤酒:" %(beers,count))
    beers = 0
    print("(%d 瓶瓶酒,% d 个瓶盖,% d 个瓶子)" %(beers,caps,bottles))
    if caps >= 4:
        print("% d个瓶盖换% d 瓶酒" % (caps-caps%4,caps//4))
        beers=beers+caps//4
        caps=caps%4
    if bottles >=2:
        print("% d个瓶子换% d个瓶啤酒" % (bottles-bottles%2,bottles//2))
        beers = beers+bottles//2
        bottles = bottles%2
    print("% d瓶啤酒,% d个瓶盖,% d个瓶子" % (beers,caps,bottles))

print("总计喝掉% d瓶啤酒,剩下% d个盖子和% d个瓶子" %(count, caps,bottles))

