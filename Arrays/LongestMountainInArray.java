/*https://leetcode.com/problems/longest-mountain-in-array/*/

class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] left = new int[n], right = new int[n];
        for (int i = 1; i < n; ++i)
            if (arr[i] > arr[i-1])
                left[i] = left[i-1]+1;
        for (int i = n-2; i >= 0; --i)
            if (arr[i] > arr[i+1])
                right[i] = right[i+1]+1;
        int max = 0;
        for (int i = 1; i < n-1; ++i)
            if (left[i]+right[i]+1 > max && left[i] != 0 && right[i] != 0)
                max = left[i]+right[i]+1;
        return max;
    }
}

class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] right = new int[n];
        for (int i = n-2; i >= 0; --i)
            if (arr[i] > arr[i+1])
                right[i] = right[i+1]+1;
        int max = 0, curr = 0;
        for (int i = 1; i < n-1; ++i)
        {
            if (arr[i] > arr[i-1])
                ++curr;
            else curr = 0;
            if (curr+right[i]+1 > max && curr != 0 && right[i] != 0)
                max = curr+right[i]+1;
        }
        return max;
    }
}

class Solution {
    public int longestMountain(int[] arr) {
        int ans=0;
        for(int i=0;i<arr.length-2;i++){
            int count=0;
            if(arr[i]<arr[i+1] && arr[i+1]>arr[i+2]){
                int j=i+1;
                while(j>=1 && arr[j]>arr[j-1]  ){
                    count++;
                    j--;
                }
                j=i+1;
                while(j<arr.length-1 && arr[j]>arr[j+1] ) {
                    count++;
                    j++;
                }
                if(count>ans&& count!=0){
                    ans=count;
                   
                }
                
            }
        }
        if(ans==0){
            return 0;
        }
        return ans+1;
    }
}