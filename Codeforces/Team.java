/*https://codeforces.com/problemset/problem/231/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Team
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		int count = 0;
		for (int i = 0; i < n; ++i)
		{
			String[] tokens = br.readLine().trim().split(" +");
			int currCount = 0;
			if (tokens[0].charAt(0) == '1')
				++currCount;
			if (tokens[1].charAt(0) == '1')
				++currCount;
			if (tokens[2].charAt(0) == '1')
				++currCount;
			if (currCount >= 2)
				++count;
		}
		System.out.println(count);
	}
}