/*https://codeforces.com/problemset/problem/1141/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class MaximalContinuousRest
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		String[] tokens = reader.readLine().trim().split(" +");
		int maxLen = 0, currLen = 0;
		for (int i = 0; i < 2*n; ++i)
		{
			if (tokens[i%n].equals("1"))
				++currLen;
			else if (tokens[i%n].equals("0"))
			{
				maxLen = Math.max(currLen,maxLen);
				currLen = 0;
			}
		}
		System.out.println(Math.max(maxLen,currLen));
	}
}