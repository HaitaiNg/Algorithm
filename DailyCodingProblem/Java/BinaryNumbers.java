// Java program to add two numbers without using arithmetic operators
import java.io.*;

class GFC
{
	static int Add(int x, int y)
	{
		//Iterate until there is no carry
		while( y != 0){
		//carry now contains common set bits of x and y
		int carry = x & y;
		//sum of bits of x and y where at least one of bits is not set
		x = x ^ y;
		// carry is shifted by one so that adding it to x gives it the required sum
		y = carry << 1;
		}
	return x;
	}

public static void main(String arg[])
{
	System.out.println(Add(15,32));
}
}
