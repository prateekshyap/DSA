/*https://codeforces.com/problemset/problem/141/A*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class AmusingJoke
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int[] nameHash = new int[26], shuffleHash = new int[26];
		String newYearMan = bufferedReader.readLine(), christmasMan = bufferedReader.readLine(), permutation = bufferedReader.readLine();
		for (int i = 0; i < newYearMan.length(); ++i)
			++nameHash[newYearMan.charAt(i)-'A'];
		for (int i = 0; i < christmasMan.length(); ++i)
			++nameHash[christmasMan.charAt(i)-'A'];
		for (int i = 0; i < permutation.length(); ++i)
			++shuffleHash[permutation.charAt(i)-'A'];
		boolean result = true;
		for (int i = 0; i < 26; ++i)
			if (nameHash[i] != shuffleHash[i])
				result = false;
		System.out.println(result ? "YES" : "NO");
	}
}