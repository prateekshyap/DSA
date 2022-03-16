/*https://practice.geeksforgeeks.org/problems/distinct-absolute-array-elements4529/1#*/

//sliding window technique
class Solution
{
    int distinctCount(int[] arr, int n)
    {
        // code here
        int distinctCount = 0, i = 0, j = -1, prev = -1; //i is the start of the window and j is the end of the window
        while (i < n && j < n) //till we have more elements
        {
            if (j+1 < n && arr[i] == arr[j+1]) ++j; //extend the current window if possible
            else //if unable to extend
            {
                if (prev != -1) //check if the negative corresponding number is present or not
                {
                    while (prev >= 0 && arr[prev] > arr[i]*(-1)) --prev; //till the negative number is larger, reduce the index
                    if (prev >= 0 && arr[prev] != arr[i]*(-1)) ++distinctCount; //if the next element is NOT the negation of current number, increase count
                    else if (prev == -1) ++distinctCount; //if breakpoint is not found, then also increase count
                }
                else ++distinctCount; //if breakpoint is not found, then increase count
                i = j+1; //set start to the next window
            }
            if (i < n && (arr[i] == 0 || (arr[i] > 0 && (i == 0 || arr[i-1] < 0)))) prev = i-1; //update the breakpoint when needed
        }
        return distinctCount;
    }
}