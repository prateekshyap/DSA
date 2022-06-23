/*https://practice.geeksforgeeks.org/problems/activity-selection-1587115620/1/*/

class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        int[][] times = new int[n][2];
        int i;
        for (i = 0; i < n; ++i)
        {
            times[i][0] = start[i];
            times[i][1] = end[i];
        }
        
        /*Sortnig from ending time*/
        /*Arrays.sort(times,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b)
            {
                return a[1]-b[1];
            }
        });
        
        int count = 1, last = times[0][1];
        
        for (i = 1; i < n; ++i)
        {
            if (times[i][0] > last)
            {
                ++count;
                last = times[i][1];
            }
        }
        
        return count;*/
        
        /*Sorting from starting time*/
        Arrays.sort(times,new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b)
            {
                return b[0]-a[0];
            }
        });
        
        int count = 1, last = times[0][0];
        
        for (i = 1; i < n; ++i)
        {
            if (times[i][1] < last)
            {
                ++count;
                last = times[i][0];
            }
        }
        
        return count;
    }
}