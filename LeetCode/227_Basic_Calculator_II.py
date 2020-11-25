#Very ugly solution (2 stacks, 2 O(n) loops)

import math 
class Solution:
    def calculate(self, s: str) -> int:
        stack = [] 
        num = ""
        for i in s:
            if i.isdigit():
                num += i 
            elif i in "+-/*":
                stack.append(int(num))
                num = "" 
                stack.append(i)
        stack.append(int(num))
        
        result = [] 
        currentSign = 1 
        j = 0 
        while(j < len(stack)):
            v = str(stack[j])
            if v.isdigit():
                print(str(v) + "  " + str(currentSign))
                if(currentSign == 1):
                    result.append(int(v))
                else:
                    result.append(-1*int(v))
            elif v in "*/":
                j += 1 
                next = stack[j] 
                lru = result.pop() 
                if v == "*":
                    result.append(next*lru)
                else:
                    if currentSign == 0:
                        result.append(ceil(lru/next))
                    else:
                        result.append(floor(lru/next))
                j += 1
                continue
            elif v in "-+":
                if v == "+":
                    currentSign = 1 
                else:
                    currentSign = 0 
            j += 1 
        return sum(result) 
            
                