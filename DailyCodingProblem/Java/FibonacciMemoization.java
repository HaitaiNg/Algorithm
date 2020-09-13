package Java;

// O(n) space | O(n) run time 
public class FibonacciMemoization { 
    public int fib(int n ){
        if (n < 2) return n; 
        int[] cache = new int[n + 1 ]; 
        for(int i = 0; i < cache.length; i++)
        {
            cache[i] = -1; 
        }
        cache[0] = 1; 
        cache[1] = 1; 
        return fib(n, cache); 
    }

    public int fib(int n, int[] cache){
        if (cache[n] >= 0) return cache[n]; 
        cache[n] = fib(n - 1, cache) + fib(n-2, cache); 
        return cache[n]; 
    }
}