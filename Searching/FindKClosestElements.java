/*https://leetcode.com/problems/find-k-closest-elements/*/

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0, end = arr.length-1, i = -1, j = -1;
        while (start <= end)
        {
            int mid = start+(end-start)/2;
            if (arr[mid] == x)
            {
                i = mid; break;
            }
            else if (arr[mid] < x && (mid == arr.length-1 || arr[mid+1] > x))
            {
                i = mid; break;
            }
            else if (arr[mid] < x) start = mid+1;
            else end = mid-1;
        }
        j = i+1;
        List<Integer> result = new ArrayList<Integer>();
        for (int loop = 0; loop < k; ++loop)
        {
            if (i == -1 && j == arr.length) break;
            else if (i == -1) result.add(arr[j++]);
            else if (j == arr.length) result.add(arr[i--]);
            else if (Math.abs(arr[i]-x) < Math.abs(arr[j]-x)) result.add(arr[i--]);
            else if (Math.abs(arr[i]-x) > Math.abs(arr[j]-x)) result.add(arr[j++]);
            else result.add(arr[i--]);
        }
        Collections.sort(result);
        return result;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length, low = 0, high = n-k;
        List<Integer> result = new ArrayList<Integer>();
        while (low < high)
        {
            int mid = low+(high-low)/2;
            if (x-arr[mid] > arr[mid+k]-x)
                low = mid+1;
            else high = mid;
        }
        for (int i = low; i < low+k; ++i)
            result.add(arr[i]);
        return result;
    }
}