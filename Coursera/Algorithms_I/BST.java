public class BST {
    private Key key;
    private Value val;
    private Node left, right; 

    public Node(Key key, Value value)
    {
        this.key = key;
        this.value = value;    
    }

    public Value get(Key key)
    {
        Node x = root; 
        while(x != null)
        {
            int cmp = key.compareTo(x.key); 
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val; 
        }
        return null; 
    }

    public void put(Key key, Value val)
    {
        root = put(root, key, val); 
    }

    private Node put(Node x, Key key, Value value)
    {
        if (x == null) return new Node(key, value); 
        int cmp = key.compareTo(x.key); 
        if(cmp < 0) x.left = put(x.left, key, value); 
        else if (cmp > 0) x.right = put(x.right, key, value); 
        else x.value = value; 
        return x; 
    }

    public Key floor(Key key)
    {
        Node x = floor(root, key);
        if( x == null) return null;
        return x.key; 
    }

    private Node floor(Node x, Key key)
    {
        if( x == null) return null; 
        int cmp = key.compareTo(x.key); 
        if(cmp == 0) return x;
        if(cmp < 0) return floor(x.left, key); 
        Node t = floor(x.right, key); 
        if( t != null) return t; 
        else return x; 
    }

    public vboid deleteMin()
    {
        root = deleteMin(root); 
    }

    private Node deleteMin(Node x)
    {
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.count = 1 + size(x.left) + size(x.right); 
        return x; 
    }
    

    // Inorder-traversal
    // Pre-order Traversal
    // Post-order Traversal 


    public void delete(Key key)
    {
        root = delete(root, key); 
    }

    private Node delete(Node x, Key key)
    {
        if(x== null) return null;
        int cmp = key.compareTo(x.key); 
        if(cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key); 
        else{
            if (x.right == null) return x.left;
            if (x.left == null) return x.right; 

            Node t = x; //< replace with successor 
            x = min(t.right);
            x.right = deleteMin(t.right); 
            x.left = t.left; 
        }
        x.count = size(x.left) + size(x.right) + 1; 
        return x; 
    }
}
