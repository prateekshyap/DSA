/*https://practice.geeksforgeeks.org/problems/move-all-negative-elements-to-end1813/1*/

class Solution {
    public void segregateElements(int arr[], int n)
    {
        //run two pointers, one from start and other from end
        int fromLeft = 0, fromRight = n-1, toLeft = 0, toRight = n-1;
        int[] newArr = new int[n];
        while (fromLeft < n && fromRight >= 0)
        {
            //the pointer running from the start stores the positive numbers
            if (arr[fromLeft] > 0)
                newArr[toLeft++] = arr[fromLeft];
            ++fromLeft;

            //the pointer running from the end stores the negative numbers
            if (arr[fromRight] < 0)
                newArr[toRight--] = arr[fromRight];
            --fromRight;
        }
        for (int i = 0; i < n; ++i)
            arr[i] = newArr[i];
    }
}