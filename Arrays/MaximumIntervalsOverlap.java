/*https://practice.geeksforgeeks.org/problems/maximum-intervals-overlap5708/1*/

class Solution
{
	public int[] findMaxGuests(int[] Entry,int Exit[], int N){
        // add code here.
        int i, maxVal = 0;
        for (i = 0; i < N; ++i)
            if (Exit[i] > maxVal) maxVal = Exit[i];
        int[] pre = new int[maxVal+2];
        for (i = 0; i < N; ++i)
        {
            ++pre[Entry[i]];
            --pre[Exit[i]+1];
        }
        for (i = 0; i <= maxVal; ++i)
            pre[i+1] += pre[i];
        int index = -1;
        int max = 0;
        for (i = 0; i <= maxVal; ++i)
            if (pre[i] > max)
            {
                max = pre[i];
                index = i;
            }
        return new int[]{max,index};
	}
}