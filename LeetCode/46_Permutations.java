//Solution by Isaac3 
//Recursion with backtracking 
//reference: https://leetcode.com/problems/permutations/discuss/18239/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partioning)

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> listOfPermutations = new ArrayList<>(); 
        backtrack(listOfPermutations, new ArrayList<>(), nums); 
        return listOfPermutations; 
    }
    
    private void backtrack(List<List<Integer>> listOfPermutations, List<Integer> temporaryList, int[] nums)
    {
        if(temporaryList.size() == nums.length)
        {
            listOfPermutations.add(new ArrayList<>(temporaryList)); 
        }
        else
        {
            for(int i = 0; i < nums.length; i++)
            {
                if(temporaryList.contains(nums[i]))
                {
                    continue;
                }
                else
                {
                    temporaryList.add(nums[i]); 
                    backtrack(listOfPermutations, temporaryList, nums); 
                    temporaryList.remove(temporaryList.size() - 1); 
                }
            }
        }
    }
    
}
