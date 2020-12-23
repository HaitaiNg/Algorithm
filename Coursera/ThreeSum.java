public class ThreeSum{
    public static int count(int[] a){
        int count = 0; 
        for(int i = 0; i < a.length; i++)
        {
            for(int j = i + 1; j < a.length; j++)
            {
                for(int k = j + 1; k < a.length; k++)
                {
                    if (a[i] + a[j] + a[k] == 0) count ++; 
                }
            }           
        }
        return count; 
    }

    public static void main(String[] args)
    {
        int[] a = In.readInts(args[0]); 
        System.out.println(count(a)); 
    }
}