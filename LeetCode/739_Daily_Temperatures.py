class Solution:
    def dailyTemperatures(self, T: List[int]) -> List[int]:
        stack = [] 
        returnArray = [0] * len(T) 
        for i in range(0, len(T)):
            while(len(stack) > 0 and T[i] > T[stack[len(stack) - 1]]):
                index = stack.pop() 
                returnArray[index] = i - index 
            stack.append(i)
        return returnArray 