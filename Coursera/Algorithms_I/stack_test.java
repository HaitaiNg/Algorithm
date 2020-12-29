public static void main(String[] args)
{
    StackOfStrings stack = new StackOfStrings(); 
    while(!StdIn.isEmpty()){
        String s = Stdin.readString(); 
        if(s.equals("-")) StdOut.print(stack.pop()); 
        else{
            stack.push(s); 
        }
    }
}