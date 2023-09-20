
has_ticket = input("是否有车票？(是/否): ").strip().lower()
if has_ticket == "是":
    # 乘客有车票，进行行李安检
    knife_length = float(input("请输入刀具长度（厘米）："))
    if knife_length > 10:
        print("刀具长度超过10厘米，不允许上车。")
    else:
        print("安检通过，顺利进站。")
else:
    print("没有车票，不允许进站。")
