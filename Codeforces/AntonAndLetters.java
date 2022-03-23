/*https://codeforces.com/problemset/problem/443/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AntonAndLetters
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String input = bufferedReader.readLine();
		int[] hash = new int[26];
		int uniqueCount = 0;
		for (int i = 0; i < input.length(); ++i)
			if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
				++hash[input.charAt(i)-'a'];
		for (int i = 0; i < 26; ++i)
			if (hash[i] > 0)
				++uniqueCount;
		System.out.println(uniqueCount);
	}
}