'''
    arr = [3,0,2,1,2], start = 2
    
    start at 2 -> (1) -> 1: 2+2 = 4 || 2 - 2 = 0 
          at 4 -> (2) -> 4: 4 + = 6 (xx) || (4 - 2) = 2 
          at 0 -> (0) -> 3: 0 + 3 = 3 || (0 - 3) = -3 (xx) 
          at 3 -> (1) -> 3: 3 + 1 = 4 || 3 - 1 == 2 
          
    table [index] = arr[i] = 4 
    arr[index] = {4, 0} // key = index, value = [new indexes] 
    if index == 0 return true 
    
    --> first create the map of {index} and all possible routes (adjacency list) 
    --> then use breadth first search to find all possibilities 
    
    [4,2,3,0,3,1,2]
    at 4 : 
        0 = 4 + 0 = 4 
            4 - 0 = 4 
    at 2 : 
        1 = 1 + 2 = 3 
            1 - 2 = -1 
'''

class Solution(object):
    def bfs(self, visited, graph, node, queue, arr): 
        visited.append(node) 
        queue.append(node) 
        while queue: 
            s = queue.pop(0)
            if arr[s] == 0:
                return True
            else:
                print(s)
            
            for neighbor in graph[s]:
                if neighbor not in visited:
                    visited.append(neighbor)
                    queue.append(neighbor) 
                    
    
    def canReach(self, arr, start):
        #create adjacency list 
        indexMap = {} 
        index = 0 
        for i in arr:
            plus, minus = index + i, index - i
            newIndex = [] 
            if plus < len(arr) and plus >= 0: 
                newIndex.append(plus) 
            if minus >= 0 and minus < len(arr): 
                newIndex.append(minus) 
            indexMap[index] = newIndex 
            index += 1 
    
        #breadth first search 
        visited = [] 
        queue = [] 
        val = self.bfs(visited, indexMap, start, queue, arr) 
        if(val):
            return True
        else:
            return False 
        
        
        """
        :type arr: List[int]
        :type start: int
        :rtype: bool
        """
        