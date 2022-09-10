/*https://leetcode.com/problems/car-fleet/*/

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] car = new int[n][2];
        for (int i = 0; i < n; ++i)
        {
            car[i][0] = position[i];
            car[i][1] = speed[i];
        }
        Arrays.sort(car,(a,b)->(a[0]-b[0]));
        Stack<Double> stack = new Stack<Double>();
        for (int i = n-1; i >= 0; --i)
        {
            double time = (double)(target-car[i][0])/(double)(car[i][1]);
            if (!stack.isEmpty() && time <= stack.peek()) continue;
            stack.push(time);
        }
        return stack.size();
    }
}