/*https://practice.geeksforgeeks.org/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum-set-2/1/*/

class Solution {
    static ArrayList<Integer> temp1, temp2;
    static int minDiff;
    public static ArrayList<ArrayList<Integer>> minDifference(int n, int[] arr) {
        // code here
        minDiff = Integer.MAX_VALUE;
        temp1 = new ArrayList<Integer>();
        temp2 = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list1 = new ArrayList<Integer>(), list2 = new ArrayList<Integer>();
        solve(arr, 0, n, n/2, list1, list2, 0, 0);
        //System.out.println(minDiff);
        result.add(temp1); 
        result.add(temp2);
        return result;
    }
    
    public static void solve(int[] arr, int index, int n, int limit,
    ArrayList<Integer> list1, ArrayList<Integer> list2, int sum1, int sum2)
    {
        //if (temp1.size() != 0) return;
        if (index == n)
        {
           // System.out.println(sum1+" "+sum2);
            if (Math.abs(list1.size()-list2.size()) <= 1)
            {
                if (Math.abs(sum1-sum2) < minDiff)
                {
                    temp1.clear(); temp2.clear();
                    minDiff = Math.abs(sum1-sum2);
                    for (Integer elem : list1) temp2.add(elem);
                    for (Integer elem : list2) temp1.add(elem);
                }
            }
            return;
        }
        
        if (list1.size() < limit)
        {
            list1.add(arr[index]);
            sum1 += arr[index];
            solve(arr, index+1, n, limit, list1, list2, sum1, sum2);
            sum1 -= arr[index];
            list1.remove(list1.size()-1);
        }
        if (list2.size() < limit)
        {
            list2.add(arr[index]);
            sum2 += arr[index];
            solve(arr, index+1, n, limit, list1, list2, sum1, sum2);
            sum2 -= arr[index];
            list2.remove(list2.size()-1);
        }
    }
}