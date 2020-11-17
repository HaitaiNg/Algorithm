class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> r = new ArrayList<Integer>(); 
        HashMap<Integer, Integer> k = new HashMap<Integer, Integer>(); 
        int frequency = nums.length / 3; 
        for(int i : nums)
        {
            if(k.containsKey(i)){
                k.put(i, k.get(i) + 1); 
            }
            else{
                k.put(i, 1); 
            }
            
            if((k.get(i) > frequency) && (!r.contains(i)))
            {
                r.add(i); 
            }
        }
        
        return r; 
    }
}