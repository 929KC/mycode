# 创建一个空的生词本（集合）
vocabulary_set = set()

# 查看生词列表
def view_vocabulary():
    if not vocabulary_set:
        print("生词本内容为空")
    else:
        print("生词本中的单词:")
        for word in vocabulary_set:
            print(word)

# 背单词
def learn_word():
    if not vocabulary_set:
        print("生词本内容为空")
        return

    word = next(iter(vocabulary_set))
    translation = input(f"请翻译单词 '{word}': ")

    if translation == word:
        print("太棒了！")
    else:
        print("再想想。")

# 添加新单词
def add_word():
    new_word = input("请输入新单词: ")
    if new_word in vocabulary_set:
        print("此单词已存在")
    else:
        translation = input("请输入翻译: ")
        vocabulary_set.add(new_word)
        print(f"单词 '{new_word}' 添加成功")

# 删除单词
def remove_word():
    view_vocabulary()
    word_to_remove = input("请输入要删除的单词: ")
    if word_to_remove in vocabulary_set:
        vocabulary_set.remove(word_to_remove)
        print("删除成功")
    else:
        print("删除的单词不存在")

# 清空生词本
def clear_vocabulary():
    if not vocabulary_set:
        print("生词本内容为空")
    else:
        vocabulary_set.clear()
        print("生词本已清空")

# 主程序循环
while True:
    print("\n生词本功能选项:")
    print("1. 查看生词列表")
    print("2. 背单词")
    print("3. 添加新单词")
    print("4. 删除单词")
    print("5. 清空生词本")
    print("6. 退出生词本")
    choice = input("请选择功能 (1/2/3/4/5/6): ")
    if choice == '1':
        view_vocabulary()
    elif choice == '2':
        learn_word()
    elif choice == '3':
        add_word()
    elif choice == '4':
        remove_word()
    elif choice == '5':
        clear_vocabulary()
    elif choice == '6':
        break
    else:
        print("无效的选择，请重新选择。")
print("生词本已退出。")
