import random

# 生成一个随机数字作为答案
answer = random.randint(1, 100)
# 初始化变量
guesses = 0
max_guesses = 5
# 开始游戏
print("欢迎参加猜数字游戏！我已经想好了一个1到100之间的数字。")
print(f"你有{max_guesses}次机会来猜测它。")

while guesses < max_guesses:
    # 获取用户猜测的数字
    guess = int(input("请输入你猜测的数字: "))
    guesses += 1

    # 检查猜测的数字与答案的关系
    if guess < answer:
        print("很遗憾，你猜小了。")
    elif guess > answer:
        print("很遗憾，你猜大了。")
    else:
        print(f"恭喜，你猜对了！答案是{answer}。你用了{guesses}次机会猜对了。")
        break
# 如果没有猜中，显示答案
if guesses == max_guesses:
    print(f"很遗憾，你没有在{max_guesses}次机会内猜中，答案是{answer}。")
