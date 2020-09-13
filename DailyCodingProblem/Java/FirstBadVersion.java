/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);

      iF you are setting mid = (left + right) / 2 you have to be very careful.
      Unless you are using a language that does not overflow such as Python,
      left + right could overflow. One way to fix this is to use
      ( left + (left + right) / 2) instead

      O(log(n)): Search space is halved each time, so the time complexity is
      O(log(n))
      Space complexity: O(1)
      */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n ;
        while(left < right)
        {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid))
            {
                right = mid;
            }
            else
            {
                left = mid + 1;
            }
        }
        return left;
    }
}
