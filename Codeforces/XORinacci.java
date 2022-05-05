/*https://codeforces.com/problemset/problem/1208/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.HashMap;

public class XORinacci
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		int a, b, n, c = 0;
		String[] tokens;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		while (tests-- > 0)
		{
			map.clear();
			tokens = reader.readLine().trim().split(" +");
			a = Integer.parseInt(tokens[0]);
			b = Integer.parseInt(tokens[1]);
			n = Integer.parseInt(tokens[2]);
			if (n == 0)
			{
				System.out.println(a);
				map.put(a,0);
			}
			else if (n == 1)
			{
				System.out.println(b);
				map.put(b,1);
			}
			else
			{
				while (n >= 2)
				{
					c = a^b;
					a = b;
					b = c;
					if (map.containsKey(c))
					{
						n %= (n-(Integer)map.get(c));
					}
					map.put(c,n);
					--n;
				}
				System.out.println(c);
			}
		}
	}
}