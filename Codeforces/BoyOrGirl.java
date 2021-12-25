/*https://codeforces.com/problemset/problem/236/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class BoyOrGirl
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		int[] hash = new int[26];
		for (char ch : str)
			++hash[ch-'a'];
		int count = 0;
		for (int i = 0; i < 26; ++i)
			if (hash[i] != 0)
				++count;
		System.out.println(count%2 == 0 ? "CHAT WITH HER!" : "IGNORE HIM!");
	}
}