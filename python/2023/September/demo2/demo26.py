str = 'skdaskerkjsalkj'
letter_count = {}
for char in str:
    if char in letter_count:
        letter_count[char] += 1
    else:
        letter_count[char] = 1

print(letter_count)
