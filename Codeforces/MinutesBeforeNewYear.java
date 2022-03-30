/*https://codeforces.com/problemset/problem/1283/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class MinutesBeforeNewYear
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		int h, m, result;
		String[] tokens;
		while (tests-- > 0)
		{
			tokens = reader.readLine().trim().split(" +");
			h = Integer.parseInt(tokens[0]);
			m = Integer.parseInt(tokens[1]);
			result = 0;
			result += (60*(24-h));
			result -= m;
			if (result == 1440) System.out.println("0");
			else System.out.println(result);
		}
	}
}