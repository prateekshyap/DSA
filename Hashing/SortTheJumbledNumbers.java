/*https://leetcode.com/problems/sort-the-jumbled-numbers/*/

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] mapNums = new int[n][2];
        for (int i = 0; i < n; ++i)
        {
            int num = nums[i], mapNum = 0;
            int pow = 1;
            while (num != -1)
            {
                int digit = num%10;
                mapNum = (mapping[digit]*pow)+mapNum;
                pow *= 10;
                if (num <= 9) num = -1;
                else num /= 10;
            }
            mapNums[i][0] = nums[i];
            mapNums[i][1] = mapNum;
        }
        Arrays.sort(mapNums,(a,b)->(a[1]-b[1]));
        int[] result = new int[n];
        for (int i = 0; i < n; ++i)
            result[i] = mapNums[i][0];
        return result;
    }
}