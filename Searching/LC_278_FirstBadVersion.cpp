/*
https://leetcode.com/problems/first-bad-version/
278. First Bad Version

*/

// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
public:
    int firstBadVersion_1(int n) {
        
        int low = 1;
        int high = n;
        
        while(low<=high)
        {
            int mid= low+(high-low)/2;
            bool isMidBad = isBadVersion(mid);
            if( isMidBad && !isBadVersion(mid-1))
                return mid;
            else if(isMidBad)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
        
    }
    
    int firstBadVersion(int n) {
        
        int low = 1, high = n, mid;
        while(low<=high)
        {
             mid = low+((high-low)>>1);
            if( isBadVersion(mid))
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
        
    }
};