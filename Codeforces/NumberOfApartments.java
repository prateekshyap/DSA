/*https://codeforces.com/problemset/problem/1430/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class NumberOfApartments
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		int n, three, five, seven;
		while (tests-- > 0)
		{
			three = five = seven = 0;
			n = Integer.parseInt(reader.readLine());
			if ((n-((n/5)*5))%2 == 0)
			{
				five = n/5;
				n -= (n/5)*5;
				seven = n/2;
				five -= (n/2);
				if (three < 0 || five < 0 || seven < 0)
					System.out.println("-1");
				else
					System.out.println(three+" "+five+" "+seven);
			}
			else
				System.out.println("-1");
		}
	}
}