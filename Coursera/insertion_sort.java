/*
Base case: If the array is an ascending order, insertion makes n-1 compares 
and 0 exchanges 

Worst case: If the array is an descending order (and no dupplicates)
insertion sort makes ~(N^2)/2 compares and ~(N^2)/2 exchanges 

*/


public class Insertion
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i = 0; i < N; i++)
        {
            for(int j = i; j > 0; j--)
            {
                if(less(a[j], a[j-1])){
                    exch(a, j, j -1);
                }
                else{
                    break; 
                }
            }
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