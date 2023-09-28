team = ["赵丽颖", "王一博", "杨幂", "王鹤棣", "迪丽热巴", "肖战"]
#          0       1       2      3         4       5
#         1        2        3    4       5      6
# 1 3 5
#2  4 6

# #创建两个空列表，一个用于存放男明星，一个用于存放女明星
# male_stars = []
# female_stars = []
# # 遍历整个团队列表，根据性别将明星添加到相应的列表中
# for star in team:
#     if star in ["王一博", "王鹤棣", "肖战"]:
#         male_stars.append(star)
#     else:
#         female_stars.append(star)
# # 输出男女明星列表
# print("男明星：", male_stars)
# print("女明星：", female_stars)


team = ["赵丽颖", "王一博", "杨幂", "王鹤棣", "迪丽热巴", "肖战"]

# 创建两个空列表，一个用于存放男明星，一个用于存放女明星
male_stars = []
female_stars = []

# 使用enumerate函数遍历团队列表并获取索引和值
for index, star in enumerate(team):
    # 偶数索引对应男明星，奇数索引对应女明星
    if index % 2 == 0:
        male_stars.append(star)
    else:
        female_stars.append(star)

# 输出男女明星列表
print("男明星：", male_stars)
print("女明星：", female_stars)
