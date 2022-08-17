/*https://practice.geeksforgeeks.org/problems/count-of-ap-subsequences0016/1*/

class Solution{

    static long count(int N, int A[])
    {
        // code here
        int i, j, diff, total = 0, weak = 0, prev;
        long check;
        Map<Integer,Integer>[] dp = new Map[N];
        for (i = 0; i < N; ++i) //for each element
        {
            dp[i] = new HashMap<Integer,Integer>(); //initialize the new hashmap
            for (j = 0; j < i; ++j) //for each previous element
            {
                check = (long)A[i]-(long)A[j]; //get the difference
                if (check < Integer.MIN_VALUE || check > Integer.MAX_VALUE) continue;
                diff = (int)check;
                // System.out.println(i+" "+j+" "+check+" "+diff);
                prev = dp[j].getOrDefault(diff,0); //get the number of subsequences ending at that difference at the previous element
                if (prev == 0) //if no such subsequence
                {
                    ++total; //increment total
                    ++weak; //increment weak
                    dp[i].put(diff,dp[i].getOrDefault(diff,0)+1); //store in dp
                }
                else //otherwise
                {
                    total += (prev+1); //add prev+1 to total
                    ++weak; //one of the prev+1 subsequences will be weak
                    dp[i].put(diff,dp[i].getOrDefault(diff,0)+prev+1); //store in dp
                }
            }
        }
        // for (i = 0; i < n; ++i)
        //     System.out.println(i+"->"+dp[i]);
        return total+N+1; //return total
    }
}