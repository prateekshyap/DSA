/*https://codeforces.com/problemset/problem/749/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BachGoldProblem
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		if (n%2 == 0)
		{
			System.out.println(n/2);
			for (int i = 0; i < n/2; ++i) System.out.print("2 ");
		}
		else
		{
			System.out.println(n/2);
			for (int i = 0; i < n/2-1; ++i) System.out.print("2 ");
			System.out.print("3");
		}
	}
}