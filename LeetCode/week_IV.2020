//4.22.20 (Subarray Sum Equals K) 
class Solution {
 public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k)
                    count++;
            }
        }
        return count;
    }
}
//4.23.20 Bitwise AND of Numbers 
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
         while(n>m)
           n = n & n-1;
 return m&n;
    }
}

//4.24.20 LRU Cache 
class LRUCache {
    private LinkedHashMap<Integer, Integer> cache;
    private int N;
    
    public LRUCache(int capacity) {
        this.N = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>();
    }
    
    public int get(int key) {
        int result = -1;
        
        if(this.cache.containsKey(key)){
            result = this.cache.get(key);
            this.cache.remove(key);
            this.cache.put(key, result);
        }
        
        return result;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key)){
            this.cache.remove(key);
        }else{
            if(this.cache.size() == N){
                Integer firstKey = this.cache.keySet().iterator().next();
                this.cache.remove(firstKey);
            }
        }
        
        this.cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 //4.24.20 
 public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}

//4.25.20 Longest Common Subsequence 
//4.26.20 Maximal Square
//4.27.20 First Unique Number 



