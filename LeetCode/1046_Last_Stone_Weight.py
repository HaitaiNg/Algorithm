class Solution:
    def smashStones(self, stones):
        stones = sorted(stones) 
        if(len(stones) <= 1):
            return stones 
        largest = stones.pop()
        secondLargest = stones.pop() 
        if(largest != secondLargest):
            stones.append(largest - secondLargest)
        return self.smashStones(stones)
    
    def lastStoneWeight(self, stones: List[int]) -> int:
        if(len(stones) == 0):
            return 0 
        stones = self.smashStones(stones)
        if(len(stones) == 1):
            return stones[0]
        return 0 
         
        
