/*https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x5808/1/*/

class Solution {
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        // Your code goes here
        Arrays.sort(A);
        Arrays.sort(B);
        
        int i = 0, j = (int)M-1;
        ArrayList<pair> list = new ArrayList<pair>();
        while (j >= 0 && i < N)
        {
            if (A[i]+B[j] <= X)
            {
                if (A[i]+B[j] == X)
                {
                    pair newPair = new pair(A[i],B[j]);
                    list.add(newPair);
                }
                ++i;
            }
            else --j;
        }
        pair[] result = new pair[list.size()];
        i = 0;
        for (pair newPair : list)
            result[i++] = newPair;
        return result;
    }
}