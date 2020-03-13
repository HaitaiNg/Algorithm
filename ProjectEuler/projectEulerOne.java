import java.util.*; 
import java.util.Random; 
public class projectEulerOne{

    //I: Sum up all values that divide by 3 & 5 : [1,1000]
    public static int multiplesOfThreeAndFive(){
        int target = 1000; 
        int returnValue = 0;
        for(int i = 3; i < 1000; i++){
            if(i % 3 == 0 || i % 5 == 0) returnValue = returnValue + i; 
        }
        System.out.println(returnValue); 
        return returnValue; 
    }
    //II: Fibonacci Numbers: sum up all even-valued terms 
    public static int fibonacciNumbers(int n ){
        if(n <= 1) return n; 
        return fibonacciNumbers(n - 1) + fibonacciNumbers(n - 2); 
    }
    public static int evenFibonacciNumbers(){
        int sumOfNumbers = 0; 
        int i = 0; 
        while(true){
            if(sumOfNumbers >= 4000000) break; 
            int fibonacciNumbers = fibonacciNumbers(i); 
            if(fibonacciNumbers % 2 == 0){
                sumOfNumbers += fibonacciNumbers; 
            }
            i++; 
        }
        System.out.println(sumOfNumbers);
        return sumOfNumbers;
    }



    public static void main(String[] args){
        // multiplesOfThreeAndFive();
        evenFibonacciNumbers();
    }
}
