/*https://codeforces.com/problemset/problem/59/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Word
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toCharArray();
		StringBuilder result = new StringBuilder("");
		int[] hash = new int[26];
		for (char ch : str)
		{
			if (ch >= 'a' && ch <= 'z')
				++hash[ch-'a'];
			else
				--hash[ch-'A'];
		}
		int sign = 0;
		for (int i = 0; i < 26; ++i)
			sign += hash[i];
		if (sign >= 0)
			for (char ch : str)
				result.append((ch >= 'a' && ch <= 'z') ? ch : (char)((int)ch+32));
		else
			for (char ch : str)
				result.append((ch >= 'a' && ch <= 'z') ? (char)((int)ch-32) : ch);
		System.out.println(result);
	}
}