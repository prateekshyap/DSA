/*https://practice.geeksforgeeks.org/problems/in-first-but-second5423/1*/

class Solution
{
    ArrayList<Long> findMissing(long A[], long B[], int N, int M)
    {
        HashSet<Long> set = new HashSet<Long>();
        for (int i = 0; i < M; ++i)
            set.add(B[i]);
        ArrayList<Long> list = new ArrayList<Long>();
        for (int i = 0; i < N; ++i)
            if (!set.contains(A[i]))
                list.add(A[i]);
        return list;
    }
}