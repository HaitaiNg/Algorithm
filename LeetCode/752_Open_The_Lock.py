class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        deadSet = set(deadends)
        queue = collections.deque([('0000', 0)])
        visited = set('0000')
        
        while queue: 
            (string, steps) = queue.popleft()
            if string == target:
                return steps 
            elif string in deadends:
                continue 
            for i in range(4):
                digit = int(string[i]) 
                for move in [-1,1]:
                    new_digit = (digit+move)%10 
                    new_string = string[:i]+str(new_digit)+string[i+1:]
                    if new_string not in visited:
                        visited.add(new_string)
                        queue.append((new_string, steps+1)) 
        return -1 
        