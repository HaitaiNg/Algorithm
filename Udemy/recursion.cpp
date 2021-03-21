Memory management 
Stack memory: special region in RAM 
Small Size; Fast Access; Stores function calls and local variables; No fragmentation 

Heap memory: large size; slow access; stores objects; may become fragmentated 
Local variables and function calls are stored in the stack memory (call-stack) 

Head  & Tail Recursion:
Tail recursion: If the recursive call occurs at the end of a function then it is called tail recursion 
~the tail recursion is similiar to a loop (for loop / while loop)
~this method executes all the statements before jumping into the next recursive call 

Head recrusion: If the recursive call occurs at the beginning of the function then it is called 
head recursion. 
~the method saves the state before jumping into the next recursive call 
~this means the head recursion needs more memory because we have to store the states of the actual 
function calls 
~head recursion puts more memory onto the stack 

public void tail(int N){
    if(N==1) return; 
    print(N);
    tail(N-1); //< calls the function recursively; the stack will not store previous calls 
} //< we do not need to the consider the last item to be able to get the result of the last operation 

public void head(int N){
    if(N==1) return;
    head(N-1); //< calls recursively  
    print(N); //< stack has to store the previous state (function calls) 
} //< we have to consider the last value to be able to get the result for the first operation 

What is the problem with head recursion? The problem is we may use too many frames inn the stack;
this can cause stack overflow (no more room for function calls) 

Tail recursionn is better than head recursion. Tail recursion first does some operation then
it calls itself recursively.alignas
Head recursion first calls itself recursively and then does some operation. 
What is the connection between base cases and stack overflow? (If we miss the base case definition(s)
then stack overflow can occur)

-------------

Towers Of Hanoi : Minimum number of moves : 2^n -1 //< O(N^2) time complexity 

Pseudo-code 
def hanoi(disk, source, middle, dest):
    if n == 0:
        move disk from source to dest 
        return 
    hanoi(disk-1, source, dest, middle)
    move disk from source to dest
    hanoi(disk-1, middle, source, dest) 

Recursive stack frames are totally independent of each other
Every recursive function call gets its own stack frame 
~Every stack frame has its own local variables isolated from each other 
 ~Recursive calls can not change the value of variables 
Iteration can change the values (we can update or remove values in an array for example) 

Why is it possible (at least in theory) to optimize tail recursion? (Optimization means 
its uses less memory frames in the stack)
-It is possible because tail recursionn related stack frames are independent of each other - no dependency
All Recursive Algorithms can be solved with iteration - Church Turning Thesis