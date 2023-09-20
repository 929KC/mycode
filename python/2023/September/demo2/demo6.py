price_table = {
    "01": {"first_weight": 13, "additional_weight": 3},
    "02": {"first_weight": 12, "additional_weight": 2},
    "03": {"first_weight": 14, "additional_weight": 4}
}
print("请选择地区：")
print("1. 华东地区（01）")
print("2. 华南地区（02）")
print("3. 华北地区（03）")
region_choice = input("请输入地区选择（1/2/3）: ")
if region_choice in ["1", "2", "3"]:
    region_code = "0" + region_choice
    weight = float(input("请输入寄件重量（千克）："))
    region_info = price_table.get(region_code)
    if region_info:
        first_weight_price = region_info["first_weight"]
        additional_weight_price = region_info["additional_weight"]
        if weight <= 2:
            total_price = first_weight_price
        else:
            additional_weight = weight - 2
            total_price = first_weight_price + additional_weight * additional_weight_price
        print(f"寄件费用为：{total_price}元")
    else:
        print("地区编号无效，请输入正确的地区编号（01/02/03）。")
else:
    print("选择无效，请输入正确的选择（1/2/3）。")
