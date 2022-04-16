/*https://codeforces.com/problemset/problem/439/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class DevuTheSingerAndChuruTheJoker
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n, d, i, sum = 0;
		String[] tokens;
		int[] t;
		tokens = reader.readLine().trim().split(" +");
		n = Integer.parseInt(tokens[0]);
		d = Integer.parseInt(tokens[1]);
		t = new int[n];
		tokens = reader.readLine().trim().split(" +");
		for (i = 0; i < n; ++i)
		{
			t[i] = Integer.parseInt(tokens[i]);
			sum += t[i];
		}
		if (((n-1)*10)+sum <= d) System.out.println((d-sum)/5);
		else System.out.println("-1");
	}
}