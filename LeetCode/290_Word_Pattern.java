/* Use a single index hash map, which keeps track of the first occurrences 
of each character in pattern and each word in str. As we go through each character-word
pair we insert unseen characters from patter and unseen words from str

Indices of each character and each word match up. If there is a mismatch, return false 
*/

// O(n) time (N represent the number of words in str) | O(M) space 
// represents the number of unique characters in pattern and in words str 
class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap map_index = new HashMap();
        String[] words = str.split(" ");

        if (words.length != pattern.length())
            return false;

        for (Integer i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];

            if (!map_index.containsKey(c))
                map_index.put(c, i);

            if (!map_index.containsKey(w))
                map_index.put(w, i);

            if (map_index.get(c) != map_index.get(w))
                return false;
        }

        return true;
    }
}