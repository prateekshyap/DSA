/*https://practice.geeksforgeeks.org/problems/count-smaller-elements2214/1*/

class Solution {
    int[] constructLowerArray(int[] arr, int n) {
        // code here
        ArrayList<Integer> checked = new ArrayList<Integer>();
        int[] result = new int[n];
        int i;
        
        checked.add(arr[n-1]);
        for (i = n-2; i >= 0; --i)
        {
            int pos = findPos(checked, arr[i]);
            result[i] = pos;
            checked.add(pos,arr[i]);
        }
        
        return result;
    }
    int findPos(ArrayList<Integer> pos, int num)
    {
        if (num < pos.get(0)) return 0;
        if (num > pos.get(pos.size()-1)) return pos.size();
        int low = 0, high = pos.size()-1, mid, result = -1;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (num > pos.get(mid))
            {
                result = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        return result+1;
    }
}