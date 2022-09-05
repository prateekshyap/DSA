/*https://leetcode.com/problems/heaters/*/

//binary search solution
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> heaterSet = new TreeSet<Integer>();
        for (int heater : heaters)
            heaterSet.add(heater);
        Arrays.sort(houses);
        int houseLength = houses.length, heaterLength = heaters.length;
        int low = 0, high = Math.max(heaterSet.last(),houses[houseLength-1]), mid, result = -1;
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (possible(mid,houses,heaterSet))
            {
                result = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return result;
    }
    private boolean possible(int radius, int[] houses, TreeSet<Integer> heaters)
    {
        for (int house : houses)
        {
            Integer left = heaters.floor(house);
            Integer right = heaters.ceiling(house);
            if (!((left != null && left >= house-radius) || (right != null && right <= house+radius))) return false;
        }
        return true;
    }
}

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int radius = 0, heaterCounter = 0;
        final int heaterLen = heaters.length;
        for (int i = 0; i < houses.length; ++i)
        {
            while (heaterCounter < heaterLen && heaters[heaterCounter] < houses[i])
                ++heaterCounter;
            if (heaterCounter == heaterLen)
                radius = Math.max(radius,houses[i]-heaters[heaterLen-1]);
            else if (heaterCounter == 0)
                radius = Math.max(radius,heaters[0]-houses[i]);
            else
                radius = Math.max(radius,Math.min(houses[i]-heaters[heaterCounter-1],heaters[heaterCounter]-houses[i]));
        }
        return radius;
    }
}