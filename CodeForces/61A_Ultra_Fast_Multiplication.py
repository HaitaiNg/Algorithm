#CodeForces
#Ultra Fast Multiplication 
#Python 3.7.2

import sys

n_ = input()
k_ = input()

result = ""

k_index = 0
for i in n_:
    if i == k_[k_index]:
        result += "0"
    else:
        result += "1"
    k_index +=1 
print(result) 
