/*https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1*/
/*https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/*/

/*Prateekshya's Solution*/
/*gfg*/
import java.io.*;

class GFG
{
    public static void main (String[] args) throws IOException
	{
	    BufferedReader br= new BufferedReader (new InputStreamReader (System.in));
	    int testCases = Integer.parseInt(br.readLine());
	    for (int ii = 0; ii < testCases; ++ii)
	    {
	        int dim = Integer.parseInt(br.readLine());
	        int[] arr = new int[dim];
	        String[] tokens = br.readLine().trim().split(" +");
	        for (int i = 0; i < dim; ++i)
	            arr[i] = Integer.parseInt(tokens[i]);
            List localMin = new ArrayList<Integer>();
    		List localMax = new ArrayList<Integer>();
    		int min = 0;
    		for (int i = 1; i < dim; ++i)
    		{
    			if (min == i-1 && arr[i] < min)
    			    min = i;
			    else if (arr[i] < arr[i-1])
			    {
			        if (min != (i-1))
			        {
			            localMin.add(min);
			            localMax.add(i-1);
			        }
			        min = i;
			    }
			    else if (i == arr.length-1)
			    {
			        if (min != arr.length-1)
			        {
			            localMin.add(min);
			            localMax.add(arr.length-1);
			        }
			    }
    		}
    		if (localMin.size() != 0 && localMax.size() != 0)
    		{
    		    for (int i = 0; i < localMin.size(); ++i)
    		    {
    		        System.out.print("("+localMin.get(i)+" "+localMax.get(i)+") ");
    		    }
    		    System.out.println();
    		}
    		else
		        System.out.println("No Profit");
	    }
	}
}

/*Leetcode*/
class Solution {
    public int maxProfit(int[] prices) {
        ArrayList<Integer> localMin = new ArrayList<Integer>();
        ArrayList<Integer> localMax = new ArrayList<Integer>();
        
        int min = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i)
        {
            if (min == i-1 && prices[i] < prices[min])
                min = i;
            else if (prices[i] < prices[i-1])
            {
                if (min != i-1)
                {
                    localMin.add(min);
                    localMax.add(i-1);
                }
                min = i;
            }
            else if (i == prices.length-1)
            {
                if (min != prices.length-1)
                {
                    localMin.add(min);
                    localMax.add(prices.length-1);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < localMin.size(); ++i)
            sum += prices[localMax.get(i)]-prices[localMin.get(i)];
        return sum;
    }
}

/*Pratik's Solution*/
class Solution{
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();
        int buy = 0, sell =buy+1;
        while(sell<n)
        {
            ArrayList<Integer> al = new ArrayList<Integer>();
            while(sell<n && A[sell]<=A[buy])
            {
                buy=sell;
                sell=buy+1;
            }
            while(sell<n-1 && A[sell]<A[sell+1])
            {
                sell++;
            }
            if(buy<n && sell<n)
            {
                al.add(buy);
                al.add(sell);
                aList.add(al);
            }
            buy=sell+1;
            sell=buy+1;
        }
        //System.out.print(aList);
        return aList;
    }
}
