public class QuickUnionUF{
    private int[] id; 
    public QuickUnionFind(int N)
    {
        id = new int[N]; 
        for(int i = 0; i < N; i++) id[i] = i; //< set ID of each object to itself (N array accesses)
    }
    
    private int root(int i){
        while(i != id[i]) i = id[i]; //< chase parent pointers until reach root (depth of i array accesses)
        return i; 
    }

    public boolean connected(int p, int q){
        return root(p) == root(q); //< check if p and q have same root (depth of p and q array accesses) 
    }
    public void union(int p, int q){
        int i = root(p); //< change root of p to point to root of q (depth of p and q array accesses) 
        int j = root(q); 
        id[i] = j; 
    }

    public void modifiedUnion(int p, int q){ //< major improvement over union do to size constraint
        int i = root(p);
        int j = root(q); 
        if( i == j) return;
        if(sz[i] < sz[j]) {
            id[i] = j;
             sz[j] = sz[i];
        }
        else{
            id[j] = i; sz[i] = sz[j];
        }
    }



}