/*https://codeforces.com/problemset/problem/1475/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.HashMap;

public class NewYearsNumber
{
	static HashMap<Integer,Boolean> map;
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		int n;
		while (tests-- > 0)
		{
			map = new HashMap<Integer,Boolean>();
			map.put(2020,true);
			map.put(2021,true);
			n = Integer.parseInt(reader.readLine());
			if (n < 2020) System.out.println("NO");
			else System.out.println(recur(n)?"YES":"NO");
		}
	}
	public static boolean recur(int n)
	{
		if (n == 2020 || n == 2021) return true;
		if (n < 2020) return false;
		if (map.containsKey(n-2020)) return (Boolean)map.get(n-2020);
		if (map.containsKey(n-2021)) return (Boolean)map.get(n-2021);
		boolean result = recur(n-2020) || recur(n-2021);
		map.put(n,result);
		return result;
	}
}