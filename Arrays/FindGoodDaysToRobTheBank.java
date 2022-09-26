/*https://leetcode.com/problems/find-good-days-to-rob-the-bank/*/

class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> result = new ArrayList<Integer>();
        if (time == 0)
        {
            for (int i = 0; i < security.length; ++i)
                result.add(i);
            return result;
        }
        int n = security.length;
        int[] left = new int[n], right = new int[n];
        for (int i = 1; i < n; ++i)
            if (security[i] <= security[i-1])
                left[i] = left[i-1]+1;
        for (int i = n-2; i >= 0; --i)
            if (security[i] <= security[i+1])
                right[i] = right[i+1]+1;
        // for (int i = 0; i < n; ++i)
        //     System.out.print(left[i]+" ");
        // System.out.println();
        // for (int i = 0; i < n; ++i)
        //     System.out.print(right[i]+" ");
        // System.out.println();
        for (int i = time; i < n-time; ++i)
            if (left[i] >= time && right[i] >= time)
                result.add(i);
        return result;
    }
}