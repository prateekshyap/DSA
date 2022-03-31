/*https://codeforces.com/problemset/problem/1560/B*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class WhoIsOpposite
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		String[] tokens;
		int a, b, c, d, total;
		while (tests-- > 0)
		{
			tokens = reader.readLine().trim().split(" +");
			a = Integer.parseInt(tokens[0]);
			b = Integer.parseInt(tokens[1]);
			c = Integer.parseInt(tokens[2]);
			total = Math.abs(a-b)*2;
			if (a > total || b > total || c > total)
				System.out.println("-1");
			else
			{
				if (c-(total/2) > 0) System.out.println(c-(total/2));
				else System.out.println(c+(total/2));
			}
		}
	}
}