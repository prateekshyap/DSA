/*https://codeforces.com/problemset/problem/732/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BuyAShovel
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = bufferedReader.readLine().trim().split(" +");
		int k = Integer.parseInt(tokens[0]);
		int r = Integer.parseInt(tokens[1]);
		if (k%10 == 0 || (k-r)%10 == 0) System.out.println("1");
		else if ((2*k)%10 == 0 || ((2*k)-r)%10 == 0) System.out.println("2");
		else if ((3*k)%10 == 0 || ((3*k)-r)%10 == 0) System.out.println("3");
		else if ((4*k)%10 == 0 || ((4*k)-r)%10 == 0) System.out.println("4");
		else if ((5*k)%10 == 0 || ((5*k)-r)%10 == 0) System.out.println("5");
		else if ((6*k)%10 == 0 || ((6*k)-r)%10 == 0) System.out.println("6");
		else if ((7*k)%10 == 0 || ((7*k)-r)%10 == 0) System.out.println("7");
		else if ((8*k)%10 == 0 || ((8*k)-r)%10 == 0) System.out.println("8");
		else if ((9*k)%10 == 0 || ((9*k)-r)%10 == 0) System.out.println("9");
		else System.out.println("10");
	}
}