import random
answer = random.randint(1, 100)
guesses = 0
max_guesses = 5
print("欢迎参加猜数字游戏！我已经想好了一个1到100之间的数字。")
print(f"你有{max_guesses}次机会来猜测它。")
while guesses < max_guesses:
    guess = int(input("请输入你猜测的数字: "))
    guesses += 1
    if guess < answer:
        print("很遗憾，你猜小了。")
    elif guess > answer:
        print("很遗憾，你猜大了。")
    else:
        print(f"恭喜，你猜对了！答案是{answer}。你用了{guesses}次机会猜对了。")
        break
if guesses == max_guesses:
    print(f"很遗憾，你没有在{max_guesses}次机会内猜中，答案是{answer}。")
