text = input("请输入一段文本: ")
letter_count = {}
text = text.replace(" ", "")
text = ''.join(e for e in text if e.isalpha())
text = text.lower()

for letter in text:
    if letter in letter_count:
        letter_count[letter] += 1
    else:
        letter_count[letter] = 1
print("每个字母出现的次数:")
for letter, count in letter_count.items():
    print(f"{letter}: {count}")
