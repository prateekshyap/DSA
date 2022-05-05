/*https://codeforces.com/problemset/problem/999/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;

public class ReversingEncryption
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		StringBuffer str = new StringBuffer(reader.readLine());
		int i;
		for (i = 1; i < Math.sqrt(n); ++i)
		{
			if (n%i == 0)
			{
				divisors.add(i);
				StringBuffer temp = new StringBuffer(str.substring(0,i));
				temp.reverse();
				temp.append(str.substring(i));
				str = temp;
			}
		}
		if (Math.sqrt(n) == (int)Math.sqrt(n))
		{
			i = (int)Math.sqrt(n);
			StringBuffer temp = new StringBuffer(str.substring(0,i));
			temp.reverse();
			temp.append(str.substring(i));
			str = temp;
		}
		for (int j = divisors.size()-1; j >= 0; --j)
		{
			i = n/(Integer)divisors.get(j);
			StringBuffer temp = new StringBuffer(str.substring(0,i));
			temp.reverse();
			temp.append(str.substring(i));
			str = temp;
		}
		System.out.println(str);
	}
}