class BinarySearch{
    public static int BinarySearch(int[] a, int key)
    {
        int lo = 0, high = a.length - 1; 
        while(lo < high)
        {
            int mid = (lo - (high - lo) / 2); 
            if(key < a[mid]) hi = mid - 1; 
            else if (key > a[mid]) lo = mid + 1; 
            else{
                return mid; 
            }
        }
        return -1; 
    }
}