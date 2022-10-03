/*https://leetcode.com/problems/find-in-mountain-array/*/

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length(), low = 1, high = n-2, peakIndex = -1;
        int[] cache = new int[n];
        Arrays.fill(cache,-1);
        while (low <= high)
        {
            int mid = low+(high-low)/2;
            int midElem, leftElem, rightElem;
            if (cache[mid] == -1)
                midElem = mountainArr.get(mid);
            else midElem = cache[mid];
            if (cache[mid-1] == -1)
                leftElem = mountainArr.get(mid-1);
            else leftElem = cache[mid-1];
            if (cache[mid+1] == -1)
                rightElem = mountainArr.get(mid+1);
            else rightElem = cache[mid+1];
            cache[mid] = midElem;
            cache[mid-1] = leftElem;
            cache[mid+1] = rightElem;
            if (midElem > leftElem && midElem > rightElem)
            {
                peakIndex = mid;
                break;
            }
            else if (midElem > leftElem && midElem < rightElem)
                low = mid+1;
            else high = mid-1;
        }
        low = 0;
        high = peakIndex;
        int index = -1;
        while (low <= high)
        {
            int mid = low+(high-low)/2;
            int midElem;
            if (cache[mid] == -1)
                midElem = mountainArr.get(mid);
            else midElem = cache[mid];
            cache[mid] = midElem;
            if (midElem == target)
            {
                index = mid;
                break;
            }
            else if (midElem > target)
                high = mid-1;
            else low = mid+1;
        }
        if (index != -1) return index;
        low = peakIndex;
        high = n-1;
        index = -1;
        while (low <= high)
        {
            int mid = low+(high-low)/2;
            int midElem;
            if (cache[mid] == -1)
                midElem = mountainArr.get(mid);
            else midElem = cache[mid];
            cache[mid] = midElem;
            if (midElem == target)
            {
                index = mid;
                break;
            }
            else if (midElem > target)
                low = mid+1;
            else high = mid-1;
        }
        return index;
    }
}