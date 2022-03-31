/*https://codeforces.com/problemset/problem/1325/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.HashSet;

public class CopyCopyCopyCopyCopy
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		int n, i;
		String[] tokens;
		HashSet<Integer> set = new HashSet<Integer>();
		while (tests-- > 0)
		{
			n = Integer.parseInt(reader.readLine());
			tokens = reader.readLine().trim().split(" +");
			set = new HashSet<Integer>();
			for (i = 0; i < n; ++i) set.add(Integer.parseInt(tokens[i]));
			System.out.println(set.size());
		}
	}
}