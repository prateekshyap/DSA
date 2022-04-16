/*https://codeforces.com/problemset/problem/709/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Juicer
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = reader.readLine().trim().split(" +");
		int n = Integer.parseInt(tokens[0]);
		int b = Integer.parseInt(tokens[1]);
		int d = Integer.parseInt(tokens[2]);
		int dTillNow = 0, curr, count = 0;
		tokens = reader.readLine().trim().split(" +");
		for (int i = 0; i < n; ++i)
		{
			curr = Integer.parseInt(tokens[i]);
			if (curr <= b) dTillNow += curr;
			if (dTillNow > d)
			{
				++count;
				dTillNow = 0;
			}
		}
		System.out.println(count);
	}
}