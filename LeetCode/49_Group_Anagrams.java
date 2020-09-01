class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapOfAnagramsAndIndexes = new HashMap<String, List<String>>(); 
        
        for(String s: strs){
            
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedS = new String(chars); 
            
            if(mapOfAnagramsAndIndexes.containsKey(sortedS))
            {
                List<String> temporaryList = mapOfAnagramsAndIndexes.get(sortedS); 
                temporaryList.add(s); 
                mapOfAnagramsAndIndexes.put(sortedS, temporaryList); 
            }
            else
            {
                List<String> temporaryList = new ArrayList<String>(); 
                temporaryList.add(s); 
                mapOfAnagramsAndIndexes.put(sortedS, temporaryList); 
            }
        }
        
        List<List<String>> returnList = new ArrayList<List<String>>(); 
            for(String K: mapOfAnagramsAndIndexes.keySet())
            {
                returnList.add(mapOfAnagramsAndIndexes.get(K)); 
            }
            return returnList; 
    }
        
    
}
