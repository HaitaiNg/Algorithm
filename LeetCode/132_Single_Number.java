class Solution {

    // O(n) time | O(n) space 
    // Java 8 
    public int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<Integer>(); 
        for(int num: nums)
        {
            if(hashSet.contains(num)) hashSet.remove(num)a;
            else
            {
                hashSet.add(num); 
            }
        }
        Iterator<Integer> itr = hashSet.iterator();
        while(itr.hasNext())
        {
            return itr.next(); 
        }
        return -1; 
    }

    ///
    /* Bit Manipulation (We can XOR all bits)
    // XOR of zero and some bit == return bit 
    //XOR of same two bits == 0 
    // O(n) time | O(1) space 
      public int singleNumber(int[] nums) {
    int a = 0;
    for (int i : nums) {
      a ^= i;
    }
    return a;
  }
  */ 
}
