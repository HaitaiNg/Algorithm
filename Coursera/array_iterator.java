import java.util.Iterator; 

public class Stack<Item> implements Iterable<Item>
{
    //.... 
    public Iterator<Item> iterator() {return new ReverseArrayIterator();}

    private class ReverseArrayIterator implements Iterator<Item> 
    {
        private int i = N; 
        public boolean hasNext()
        {
            return i > 0; 
        }
        public void remove(){}
        public Item next() {return s[--i]; }
    }
}