import sys
input = sys.stdin.read

def main():
    data = input().split()
    
    n = int(data[0])
    m = int(data[1])
    
    word_dict = {}
    
    for i in range(2, len(data)):
        word = data[i]
        
        if len(word) < m:
            continue
        
        if word in word_dict:
            word_dict[word] += 1
        else:
            word_dict[word] = 1
    
    sorted_words = sorted(word_dict.items(), key=lambda x: (-x[1], -len(x[0]), x[0]))
    
    for word, count in sorted_words:
        print(word)

if __name__ == "__main__":
    main()

############## -시간초과 난 코드 - #################################
# n, m = map(int, input().split())

# word_dict = {}

# for i in range(n):
#     word = input()

#     if len(word) < m:
#         continue
#     else:
#         if word in word_dict:
#             word_dict[word] += 1
#         else:
#             word_dict[word] = 1

# word_dict = sorted(word_dict.items(), key = lambda x : (-x[1], -len(x[0]), x[0]))

# for i in word_dict:
#     print(i[0])