/* Given two sentences, s and t, t is a subsequence of s if all of the words
in t occur in the same order within s. Words do not have to appear
contiguously in s, but order must be maintained. For example:
given a setence "I like cheese" one example of a subsequence could be "I cheese"

Given two sentences s and t, it is guaraneed that string t is a subsequence
of string s. When reading string s from left to right, locate the first
occurrence of subsequence t. Remove this subsequence and return the
remaining elements of string s in order.

example:
  s = i like eating cheese do you like cheese
  t = like cheese
  return: i eating do you like cheese

  example II:
  s = i like soft cheese and hard cheese yum
  t= like cheese yum
  return: i soft cheese and hard cheese
  */

public class Solution{
  //Complete the missingWords function below.
  static List<String> missingWords(String s, String t)
  {
    String[] words = s.split(" ");
    String[] wordsToRemove = t.split(" ");
    int index = 0;
    // Iterate through the words of the original sentence and set
    // words that should be removed to the empty string
    for(int i = 0; i < words.length; i++)
    {
      if(words[i].equals(wordsToRemove[index])
      {
        words[i] == "";
        index++;
        if(index == wordsToRemove.length)
        {
          break; // we have removed all the words we want to remove
        }
      }
    }

    // Words that are not the empty string should be kept.
    List<String> result = new ArrayList<>();
    for(int i = 0; i < words.length; i++)
    {
      if(!words[i].equals(""))
      {
        result.add(words[i]);
      }
    }
    return result;
  }
}
