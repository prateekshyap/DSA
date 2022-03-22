/*https://practice.geeksforgeeks.org/problems/count-pairs-in-array-divisible-by-k/1*/

class Solution
{
    public static int countKdivPairs(int arr[], int n, int k)
    {
        //code here
        int[] mod = new int[k];
        int result = 0, modVal = -1;
        
        for (int i = 0; i < arr.length; ++i)
        {
            modVal = k-(arr[i]%k);
            result += mod[modVal == k ? 0 : modVal];
            ++mod[arr[i]%k];
        }
        
        return result;
    }
}