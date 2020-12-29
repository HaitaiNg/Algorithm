public class quick_sort {
    private static int partition(Comparable[] a, int lo, int hi)
    {
        int i = lo, j = hi + 1; 
        while(true)
        {
            while(less(a[++i], a[lo])){
                if(i == hi) break;      //< find item on left swap 
            }
            while (less(a[lo], a[--j]))
            {
                if(j == lo) break;  //< find item on right swap 
            }            
            if (i >= j) break; // check if two pointers cross
            exch(a, i, j);  // swap 
        }
        exch(a, lo, j); // swap with partitioning item 
        return j; // return index of item now known to be in place
    }
    
    public static void sort(Comparable[] a)
    {
        SortRandom.shuffle(a);
        sort(a, 0, a.length - 1); 
    }

    private static void sort(Comparable[] a, int lo, int hi)
    {
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi); 
    }
}
