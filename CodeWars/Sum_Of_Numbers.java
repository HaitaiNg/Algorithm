public class Sum
{
   public int GetSum(int a, int b)
   {
   if(b < a)
   {
     int tmp = a;
     a = b;
     b = tmp; 
   }
   
    if(a == b) return a; 
   
      int returnSum = 0; 
      for(int i = a; i <= b; i++)
      {
      returnSum += i; 
      }
      return returnSum; 
   }
}