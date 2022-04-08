/*https://codeforces.com/problemset/problem/1350/A*/

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class OracAndFactors
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		int num, loop;
		String[] tokens;
		int smallestFactor = -1, i;
		while (tests-- > 0)
		{
			tokens = reader.readLine().trim().split(" +");
			num = Integer.parseInt(tokens[0]);
			loop = Integer.parseInt(tokens[1]);
			smallestFactor = num;
			for (i = 2; i <= Math.sqrt(num)+1; ++i)
			{
		        if(num%i == 0)
		        {
		            smallestFactor = i;
		            break;
		        }
		    }
		    --loop;
		    num += smallestFactor;
		    num += (2*loop);
		    System.out.println(num);
		}
	}
}