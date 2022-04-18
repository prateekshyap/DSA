/*https://codeforces.com/problemset/problem/1426/B*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SymmetricMatrix
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(reader.readLine());
		int[][][] tiles;
		int n, m, i, r, c, symCount, halfSymCount;
		String[] tokens;
		while (tests-- > 0)
		{
			tokens = reader.readLine().trim().split(" +");
			n = Integer.parseInt(tokens[0]);
			m = Integer.parseInt(tokens[1]);
			tiles = new int[n][2][2];
			for (i = 0; i < n; ++i)
			{
				for (r = 0; r < 2; ++r)
				{
					tokens = reader.readLine().trim().split(" +");
					for (c = 0; c < 2; ++c)
						tiles[i][r][c] = Integer.parseInt(tokens[c]);
				}
			}
			symCount = halfSymCount = 0;
		    if (m%2 != 0) System.out.println("NO");
		    else
		    {
				for (i = 0; i < n; ++i)
				{
				    if (tiles[i][0][0] == tiles[i][1][1] && tiles[i][0][1] == tiles[i][1][0]) ++symCount;
				    else if (tiles[i][0][0] != tiles[i][1][1] && tiles[i][0][1] == tiles[i][1][0]) ++halfSymCount;
				}
				if (symCount == 0 && halfSymCount == 0) System.out.println("NO");
				else System.out.println("YES");
		    }
			
		}
	}
}
