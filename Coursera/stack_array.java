public class stack_array {
    private Item[] s; 
    private int N = 0 ; 

    public FixedCapacityStackOfStrings(int capacity)
    {
        s = new Item[capacity]; 
    }

    public boolean isEmpty()
    {
        return N = 0;
    }

    public void push(Striong item)
    {
        if(N == s.length) resize(2*size.length); 
        s[N++] = item; 
    }

    public String pop()
    {
        return s[--N]; 
    }
    

    public ResizingArrayStackOfStrings(){
        s = new Item[1;
    }

    private void resize(int capacity)
    {
        Item[] copy = new Item[capacity]; 
        for(int i = 0; i < N; i++)
        {
            copy[i] = s[i];
        }
        s = copy; 
    }
}
