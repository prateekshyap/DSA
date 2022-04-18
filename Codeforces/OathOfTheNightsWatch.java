/*https://codeforces.com/problemset/problem/768/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class OathOfTheNightsWatch
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int i, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, minCount = 0, maxCount = 0, curr;
		String[] tokens = reader.readLine().trim().split(" +");
		for (i = 0; i < n; ++i)
		{
			curr = Integer.parseInt(tokens[i]);
			if (curr < min)
			{
				min = curr;
				minCount = 1;
			}
			else if (curr == min)
				++minCount;
			if (curr > max)
			{
				max = curr;
				maxCount = 1;
			}
			else if (curr == max)
				++maxCount;
		}
		//if (minCount+maxCount == n) System.out.println("0");
		//else 
		System.out.println(n-(minCount+maxCount) > 0 ? n-(minCount+maxCount) : "0");
	}
}