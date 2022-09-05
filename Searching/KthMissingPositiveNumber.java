/*https://leetcode.com/problems/kth-missing-positive-number/*/

class Solution {
    public int findKthPositive(int[] arr, int k) {
        int index = 0, count = 0, number = 1, n = arr.length, prev = -1;
        while (count < k)
        {
            if (index >= n || arr[index] > number)
            {
                prev = number;
                ++number;
                ++count;
            }
            else if (arr[index] == number)
            {
                prev = number;
                ++number;
                ++index;
            }
        }
        return prev;
    }
}

class Solution {
    public int findKthPositive(int[] arr, int k) {
        
        int start=0,end=arr.length-1;
        
        if(k<arr[0]){
            return k;
        }
        
        while(start<=end){
            
            int mid = start + (end-start)/2;
            
            int skippedNums = arr[mid]-(mid+1);
            
            if(skippedNums<k){
                start=mid+1;
            }
            else {
                end=mid-1;
            }
            
        }
        return start+k;
    }
}