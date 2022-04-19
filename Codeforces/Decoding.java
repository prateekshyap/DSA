/*https://codeforces.com/problemset/problem/746/B*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Decoding
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		char currChar;
		StringBuffer data = new StringBuffer(reader.readLine());
		StringBuffer resultL = new StringBuffer("");
		StringBuffer resultR = new StringBuffer("");
		while (data.length() > 1)
		{
			currChar = data.charAt(data.length()-1);
			resultR.append(currChar);
			currChar = data.charAt(data.length()-2);
			resultL.append(currChar);
			data.delete(data.length()-2,data.length());
		}
		StringBuffer result = resultL;
		if (data.length() == 1)
			result.append(data.charAt(0));
		resultR.reverse();
		result.append(resultR);
		System.out.println(result);
	}
}