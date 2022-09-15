/*https://leetcode.com/problems/sell-diminishing-valued-colored-balls/*/

class Solution {
    public int maxProfit(int[] inventory, int orders) {
        int min = 0;
        int max = Integer.MIN_VALUE;
        for (int num : inventory)
            max = Math.max(max, num);
        int ans = -1;
        while (min <= max)
        {
            int mid = min + (max - min) / 2;
            if (nOrders(inventory, mid) > orders)
                min = mid + 1;
            else
            {
                ans = mid;
                max = mid-1;
            }
        }
        System.out.println(ans);
        long res = 0;
        for (int num : inventory)
        {
            if (num <= ans) continue;
            res += (long)(num + ans + 1) * (num - ans) / 2;
            orders -= (num - ans);
        }
        res += (long)orders * ans;
        return (int)(res % 1000000007);
    }
    
    private long nOrders(int[] inventory, int target) {
        long res = 0;
        for (int num : inventory)
            res += Math.max(num - target, 0);
        return res;
    }
}