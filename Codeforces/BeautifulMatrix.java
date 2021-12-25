/*https://codeforces.com/problemset/problem/263/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BeautifulMatrix
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] mat = new int[5][5];
		int r = -1, c = -1;
		for (int i = 0; i < 5; ++i)
		{
			String[] tokens = br.readLine().trim().split(" +");
			for (int j = 0; j < 5; ++j)
			{
				mat[i][j] = Integer.parseInt(tokens[j]);
				if (mat[i][j] != 0)
				{
					r = i;
					c = j;
				}
			}
		}
		System.out.println(Math.abs(r-2)+Math.abs(c-2));
	}
}