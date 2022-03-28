/*https://codeforces.com/problemset/problem/1294/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CollectingCoins
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		String[] tokens;
		int max, diff, a, b, c, n;
		while (tests-- > 0)
		{
			tokens = reader.readLine().trim().split(" +");
			a = Integer.parseInt(tokens[0]);
			b = Integer.parseInt(tokens[1]);
			c = Integer.parseInt(tokens[2]);
			n = Integer.parseInt(tokens[3]);
			max = Math.max(a,Math.max(b,c));
			diff = 0;
			diff += max-a;
			diff += max-b;
			diff += max-c;
			if (n-diff == 0) System.out.println("YES");
			else if (n-diff > 0 && (n-diff)%3 == 0) System.out.println("YES");
			else System.out.println("NO");
		}
	}
}