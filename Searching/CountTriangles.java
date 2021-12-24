/*https://practice.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1/*/

class Solution
{
    static int findNumberOfTriangles(int arr[], int n)
    {
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n-2; ++i)
        {
            for (int j = i+1; j < n-1; ++j)
            {
                int third = j+1;
                while (third < n && arr[i]+arr[j] > arr[third]) ++third;
                count += (third-j-1);
            }
        }
        return count;
    }
}