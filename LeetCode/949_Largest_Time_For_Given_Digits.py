'''
Runtime: 32 ms, faster than 78.68% of Python3 online submissions for Largest Time for Given Digits.
Memory Usage: 14 MB, less than 5.04% of Python3 online submissions for Largest Time for Given Digits.
'''

from itertools import permutations

class Solution:
    def largestTimeFromDigits(self, A: List[int]) -> str:
        A = [str(integer) for integer in A]
        timePermutations = [''.join(i) for i in permutations(A)]
        results = set() 
        for time in timePermutations:
            if(int(str(time[:2])) <= 23 and int(str(time[2:])) <= 59 and len(time) == 4):
                results.add(time)
         
        if(len(results) == 0):
            return "" 
        maxTime = max(results)
        return str(maxTime[:2] + ":" + maxTime[2:])
