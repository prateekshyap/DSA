/*https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1/*/

/*Prateekshya*/

/*O(n^2) solution*/

class Solution
{
    public int FindMaxSum(int arr[], int n)
    {
        if (n == 1) return arr[0];
        int[] table = new int[n];
        int[] maxTillNow = new int[n];
        int result = 0;
        maxTillNow[0] = table[0] = arr[0];
        table[1] = arr[1];
        maxTillNow[1] = result = Math.max(table[0],table[1]);
        if (n == 2) return result;
        for (int i = 2; i < n; ++i)
        {
            for (int j = i-2; j >= 0; --j) //i-2 because i-1 will be adjacent
            {
                if (arr[i]+table[j] > table[i])
                    table[i] = arr[i]+table[j];
            }
            result = Math.max(result,table[i]);
        }
        return result;
    }
}

/*O(n) solution*/

class Solution
{
    public int FindMaxSum(int arr[], int n)
    {
        if (n == 1) return arr[0];
        int[] table = new int[n];
        int[] maxTillNow = new int[n];
        int result = 0;
        maxTillNow[0] = table[0] = arr[0];
        table[1] = arr[1];
        maxTillNow[1] = result = Math.max(table[0],table[1]);
        if (n == 2) return result;
        for (int i = 2; i < n; ++i)
        {
            table[i] = arr[i]+maxTillNow[i-2];
            maxTillNow[i] = Math.max(maxTillNow[i-1],table[i]); //to reduce time complexity
            result = Math.max(result,table[i]);
        }
        return result;
    }
}