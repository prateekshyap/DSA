/*https://codeforces.com/problemset/problem/71/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class WayTooLongWords
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(br.readLine());
		while (testCases-- > 0)
		{
			String word = br.readLine();
			if (word.length() > 10)
			{
				StringBuilder temp = new StringBuilder();
				temp.append(word.charAt(0));
				temp.append(word.length()-2);
				temp.append(word.charAt(word.length()-1));
				word = new String(temp);
			}
			System.out.println(word);
		}
	}
}