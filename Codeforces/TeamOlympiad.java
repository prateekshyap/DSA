/*https://codeforces.com/problemset/problem/490/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.Comparator;



public class TeamOlympiad
{
	static class Pair
	{
		int index;
		int value;
		Pair(int index, int value)
		{
			this.index = index;
			this.value = value;
		}
	}
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine().trim());
		String[] tokens = reader.readLine().trim().split(" +");
		Pair[] expertise = new Pair[n];
		for (int i = 0; i < n; ++i) expertise[i] = new Pair(i+1,Integer.parseInt(tokens[i]));
		Arrays.sort(expertise, new Comparator<Pair>()
		{
			public int compare(Pair p1, Pair p2)
			{
				return p1.value-p2.value;
			}
		});
		int prog = 0, math = 0, pe = 0, progStart = -1, mathStart = -1, peStart = -1;
		for (int i = 0; i < n; ++i)
		{
			if (expertise[i].value == 1)
			{
				++prog;
				if (progStart == -1) progStart = i;
			}
			else if (expertise[i].value == 2)
			{
				++math;
				if (mathStart == -1) mathStart = i;
			}
			else
			{
				++pe;
				if (peStart == -1) peStart = i;
			}
		}
		int teams = Math.min(prog,Math.min(math,pe));
		if (teams == 0) System.out.println("0");
		else
		{
			System.out.println(teams);
			for (int i = 0; i < teams; ++i)
			{
				System.out.println((expertise[progStart++].index)+" "+(expertise[mathStart++].index)+" "+(expertise[peStart++].index));
			}
		}
	}
}