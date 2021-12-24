/*https://leetcode.com/problems/first-bad-version/*/

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start <= end)
        {
            int mid = start+(end-start)/2;
            boolean result = isBadVersion(mid);
            if (result && (mid == 1 || !isBadVersion(mid-1))) return mid;
            else if (result) end = mid-1;
            else start = mid+1;
        }
        return -1;
    }
}