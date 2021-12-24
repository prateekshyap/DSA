/*https://codeforces.com/problemset/problem/469/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class IWannaBeTheGuy
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int levels = Integer.parseInt(br.readLine());
		String[] tokens = br.readLine().trim().split(" +");
		int pass = Integer.parseInt(tokens[0]);
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 1; i < tokens.length; ++i)
			set.add(Integer.parseInt(tokens[i]));
		tokens = br.readLine().trim().split(" +");
		for (int i = 1; i < tokens.length; ++i)
			set.add(Integer.parseInt(tokens[i]));
		boolean isPassed = true;
		for (int i = 1; i <= levels; ++i)
			if (!set.contains(i))
			{
				isPassed = false;
				break;
			}
		if (isPassed)
			System.out.println("I become the guy.");
		else
			System.out.println("Oh, my keyboard!");
	}
}