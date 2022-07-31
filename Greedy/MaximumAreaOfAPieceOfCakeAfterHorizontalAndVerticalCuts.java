/*https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/*/

class Solution {
    private static final int m = (int)1e9+7;
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxHorizontalCut = horizontalCuts[0], maxVerticalCut = verticalCuts[0], i, hLen = horizontalCuts.length, vLen = verticalCuts.length;
        for (i = 1; i < horizontalCuts.length; ++i)
            if (horizontalCuts[i]-horizontalCuts[i-1] > maxHorizontalCut)
                maxHorizontalCut = horizontalCuts[i]-horizontalCuts[i-1];
        if (h-horizontalCuts[hLen-1] > maxHorizontalCut)
            maxHorizontalCut = h-horizontalCuts[hLen-1];
        for (i = 1; i < verticalCuts.length; ++i)
            if (verticalCuts[i]-verticalCuts[i-1] > maxVerticalCut)
                maxVerticalCut = verticalCuts[i]-verticalCuts[i-1];
        if (w-verticalCuts[vLen-1] > maxVerticalCut)
            maxVerticalCut = w-verticalCuts[vLen-1];
        long result = maxHorizontalCut;
        result = (result*maxVerticalCut)%m;
        return (int)result;
    }
}