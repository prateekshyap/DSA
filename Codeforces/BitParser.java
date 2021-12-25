/*https://codeforces.com/problemset/problem/282/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BitParser
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine().trim());
		int X = 0;
		while (testCases-- > 0)
		{
			String input = br.readLine();
			if (input.charAt(0) == '+' || input.charAt(2) == '+')
				++X;
			else
				--X;
		}
		System.out.println(X);
	}
}