/*https://codeforces.com/problemset/problem/1311/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AddOddOrSubtractEven
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] tokens;
		int a, b;
		while (n-- > 0)
		{
			tokens = reader.readLine().trim().split(" +");
			a = Integer.parseInt(tokens[0]);
			b = Integer.parseInt(tokens[1]);
			if (a == b) System.out.println("0");
			else if ((a > b && (a-b)%2 == 0) || (a < b && (b-a)%2 == 1)) System.out.println("1");
			else System.out.println("2");
		}
	}
}