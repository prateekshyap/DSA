/*https://codeforces.com/problemset/problem/158/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class NextRound
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tokens = br.readLine().trim().split(" +");
		int n = Integer.parseInt(tokens[0]);
		int k = Integer.parseInt(tokens[1]);
		tokens = br.readLine().trim().split(" +");
		int threshold = Integer.parseInt(tokens[k-1]);
		int index = 0;

		//if the kth player's score is 0, find the previous positive number index
		if (threshold != 0)
			index = findLastIndex(tokens,threshold,0,tokens.length-1);

		//otherwise find the last index of the kth player's score
		else
			index = findLastIndex(tokens,0,tokens.length-1);
		System.out.println(index+1);
	}
	static int findLastIndex(String[] tokens, int t, int l, int h)
	{
		if (l <= h)
		{
			int m = (l+h)/2;
			int place = Integer.parseInt(tokens[m]);
			if (place == t && (m == tokens.length-1 || Integer.parseInt(tokens[m+1]) != t))
				return m;
			if (place >= t)
				return findLastIndex(tokens,t,m+1,h);
			else
				return findLastIndex(tokens,t,l,m-1);
		}
		return -1;
	}
	static int findLastIndex(String[] tokens, int l, int h)
	{
		if (l <= h)
		{
			int m = (l+h)/2;
			int place = Integer.parseInt(tokens[m]);
			if (place != 0 && (m == tokens.length-1 || Integer.parseInt(tokens[m+1]) == 0))
				return m;
			if (place > 0)
				return findLastIndex(tokens,m+1,h);
			else if (place == 0)
				return findLastIndex(tokens,l,m-1);
		}
		return -1;
	}
}