class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stackOfNumbers = [] 
        for token in tokens: 
            if token not in ['+','*','/','-']:
                stackOfNumbers.append(int(token))
            else: 
                r = stackOfNumbers.pop()
                l = stackOfNumbers.pop() 
                
                if token == "+":
                    stackOfNumbers.append(r + l)
                elif token == "-":
                    stackOfNumbers.append(l - r) 
                elif token == "*":
                    stackOfNumbers.append(l * r) 
                else:
                    if l * r < 0 and l % r != 0: 
                        stackOfNumbers.append(l // r + 1) 
                    else:
                        stackOfNumbers.append( l // r) 
        return stackOfNumbers[-1]
                
                