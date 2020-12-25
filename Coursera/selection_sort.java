public class Selection
{
    public static void sort(Comparable[] a)
    {
        int N = a.length; 
        for(int i = 0; i < N; i++)
        {
            int min = i; 
            for(int j = i +1; j < N; j++)
            {
                if(less(a[j], a[min])) min = j;
            }
            exch(a,i,min); 
        }
    }

    
    //< Less than
    private static boolean less(Comparable V, Comparable w)
    {
        return v.compareTo(w) < 0; 
    }

    //< Exchange 
    private static void exchange(Comparable[] a, int i, int j){
        Comparable swap = a[i]; 
        a[i] = a[j]; 
        a[j] = swap; 
    }

}