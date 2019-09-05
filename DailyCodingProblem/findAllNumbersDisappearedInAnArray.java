class Solution{
  public List<Integer> findDisappearedNumbers(int[] nums)
  {
    List<Integer> missingNumbers = new ArrayList<Integer>();
    HashSet<Integer> numbers = new HashSet<Integer>();
    for(int i : nums) {
      numbers.add(i);
    }

    for(int i = 1; i <= numbers.length(); i++)
    {
      if(!numbers.contais(i))
      {
        missingNumbers.add(i);
      }
    }
    return missingNumbers;
  }
}
