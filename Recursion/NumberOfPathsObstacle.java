import java.io.*;

class NumberOfPathsObstacle
{
	public static void main(String pp[])throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter number of rows : ");
		int rows = Integer.parseInt(br.readLine());
		System.out.print("Enter numer of columns : ");
		int cols = Integer.parseInt(br.readLine());
		int[][] arr = new int[rows][cols];
		System.out.print("Enter number of obstacles : ");
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter cell id(row,col) where you want to add obstacles : ");
			int m = Integer.parseInt(br.readLine());
			while(m>=rows || m<0)
			{
				System.out.println("Enter a number less than number of rows i.e. <"+rows+" as well as the value should be >=0" );
				m = Integer.parseInt(br.readLine());
			}
			int p = Integer.parseInt(br.readLine());
			while(p>=cols || p<0)
			{
				System.out.println("Enter a number less than number of columns i.e. <"+cols+" as well as the value should be >=0" );
				p = Integer.parseInt(br.readLine());
			}
			arr[m][p] = 1;
		}
		Solution s = new Solution();
		System.out.println("Number of ways to move from top left corner to bottom right corner is "+s.uniquePathsWithObstacles(arr));
	}
}
class Solution {
    public int uniquePathsWithObstacles(int[][] arr) 
    {
        int rows = arr.length;
        int cols = arr[0].length;
        if(arr[rows-1][cols-1]==1 || arr[0][0]==1)return 0;
        int dp[][] = new int[rows][cols];
        dp[rows-1][cols-1] = 0;
        dp[0][0] = 1;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(arr[i][j]==0 && i+1<rows)dp[i+1][j]+=dp[i][j];
                if(arr[i][j]==0 && j+1<cols)dp[i][j+1]+=dp[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }
}