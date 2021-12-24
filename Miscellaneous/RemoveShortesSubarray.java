/*https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/submissions/*/

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        if (arr.length == 0 || arr.length == 1) return 0;
        int start = -1, end = -1;
        
        //checking some boundary conditions
        for (int i = 1; i < arr.length; ++i)
            if (arr[i] < arr[i-1])
            {
                start = i;
                break;
            }
        for (int i = arr.length-2; i >= 0; --i)
            if (arr[i] > arr[i+1])
            {
                end = i;
                break;
            }
        if (start == -1 && end == -1) return 0;
        boolean isDecreasing = true;
        for (int i = 1; i < arr.length; ++i)
            if (arr[i] > arr[i-1])
            {
                isDecreasing = false;
                break;
            }
        if (arr[start-1] <= arr[end+1]) return end-start+1; //if we can join the two right away
        if (!isDecreasing && arr[0] > arr[arr.length-1]) //if it is not in reverse order and the condition holds
            return start >= (arr.length-end-1) ? (arr.length-start) : (end+1);
        
        
        start = -1;
        end = -1;
        
        //fixing start
        for (int i = 1; i < arr.length; ++i)
            if (arr[i] < arr[i-1])
            {
                start = i;
                break;
            }
        
        //if start unchanged
        if (start == -1) return 0;
        int minLength = Integer.MAX_VALUE;
        
        //finding end
        end = start;
        while (end < arr.length && arr[start-1] > arr[end])
            ++end;
        for (int j = arr.length-1; j > end; --j)
            if (arr[start-1] > arr[j] || (j != arr.length-1 && arr[j] > arr[j+1]))
            {
                end = j+1;
                break;
            }
        minLength = end-start;
        --end;
        boolean isReducing = false, flag = false;
        
        //checking for better result
        while (true)
        {
            --start;
            while (start != 0 && arr[end] >= arr[start-1] && (end == arr.length-1 || arr[end] <= arr[end+1]))
                --end;
            if (end-start+1 > minLength && !isReducing)
            {
                flag = true;
                break;
            }
            else if (end-start+1 < minLength)
            {
                minLength = end-start+1;
                isReducing = true;
            }
            else if (isReducing)
                break;
        }
        
        //if start is at 0
        if (flag)
        {
            if (arr[start+1] >= arr[start]) ++start;
            while (end == arr.length-1 || arr[end] < arr[end+1])
                --end;
            if (end-start+1 < minLength && (start == 0 || arr[start-1] <= arr[end+1]))
                minLength = end-start+1;
        }
        return minLength;
    }
}