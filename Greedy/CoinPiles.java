/*https://practice.geeksforgeeks.org/problems/coin-piles5152/1/*/

//kind of sliding window
class Solution {
	//to find rightmost index of target element
    static int findRightMost(int[] a, int t, int s, int e)
    {
        if (s <= e)
        {
            int m = (s+e)/2;
            if (a[m] == t && (m == a.length-1 || a[m+1] != t))
                return m;
            else if (a[m] > t)
                return findRightMost(a,t,s,m-1);
            else if (a[m] <= t)
                return findRightMost(a,t,m+1,e);
        }
        return -1;
    }
    /*
    to find the border line for a target element such that
    elements before the border are smaller than or equal to the target
    and elements starting from the border are greater than the target
    */
    static int findBorder(int[] a, int t, int s, int e)
    {
        if (s <= e)
        {
            int m = (s+e)/2;
            if (a[m] > t && (m == 0 || a[m-1] <= t))
                return m;
            else if (a[m] <= t && m == a.length-1)
                return a.length;
            else if (a[m] > t)
                return findBorder(a,t,s,m-1);
            else if (a[m] <= t)
                return findBorder(a,t,m+1,e);
        }
        return -1;
    }
    static int minSteps(int[] A, int N, int K) {
        Arrays.sort(A); //sort the array

        //find the first border
        int border = findBorder(A,A[0]+K,0,N-1);
        
        //if all elements are equal then return 0
        if (border == -1) return 0;

        int result = 0;

        //find out the number of coins to be removed
        for (int in = border; in < N; ++in)
            result += A[in]-(A[0]+K);

        int copy = result;
        int i = 0;

        //till the border exists
        while (border < N)
        {
        	//find the rightmost index of the current minimum element
            int rMMin = findRightMost(A,A[i],0,N-1);

            //if that is N-1 then return result
            if (rMMin == N-1) return result;

            //remove the minimum piles entirely
            copy += A[i]*(rMMin-i+1);

            //find the new border for the new minimum element
            int newB = findBorder(A,A[rMMin+1]+K,rMMin+1,N-1);

            //if no border exists then break
            if (border == -1) break;

            //add the required coins on the larger piles which were previously removed
            for (int in = border; in < newB; ++in)
                copy -= A[in]-(A[i]+K);
            for (int in = newB; in < N; ++in)
                copy -= (A[rMMin+1]+K) - (A[i]+K);

            //update the result
            result = Math.min(copy,result);
            
            //get ready for next iteration
            border = newB;
            i = rMMin + 1;
        }

        return result;
    }
}