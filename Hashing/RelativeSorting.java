/*https://practice.geeksforgeeks.org/problems/relative-sorting4323/1*/

class Solution{
    // A1[] : the input array-1
    // N : size of the array A1[]
    // A2[] : the input array-2
    // M : size of the array A2[]
    
    //Function to sort an array according to the other array.
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        //Your code here
        int[] hashTable = new int[1000001];
        for (int i = 0; i < N; ++i)
            ++hashTable[A1[i]];
        int x = 0;
        for (int i = 0; i < M; ++i)
        {
            while (hashTable[A2[i]]-- > 0)
                A1[x++] = A2[i];
        }
        int p = 0;
        //System.out.println(x);
        while (x < N)
        {
            while (hashTable[p] == 0)
                ++p;
            while (hashTable[p]-- > 0)
            {
                A1[x] = p;
                ++x;        
            }
            ++p;
        }
        return A1;
    }
}