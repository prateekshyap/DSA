/*https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/*/

class Solution {
    public int findSpecialInteger(int[] arr) {
        int[] freq = new int[(int)1e5+1];
        for (int num : arr)
            ++freq[num];
        int max = 0, elem = -1;
        for (int i = 0; i < freq.length; ++i)
            if (freq[i] > max)
            {
                max = freq[i];
                elem = i;
            }
        if (max > arr.length/4) return elem;
        else return -1;
    }
}

class Solution {
    
    
    public int findSpecialInteger(int[] arr) {
        int count = arr.length / 4;
        
        for (int i = 0; i < arr.length - count; i++) {
            if (arr[i] == arr[i + count]) {
                return arr[i];
            }
        }
        
        return arr[0];
    }
}