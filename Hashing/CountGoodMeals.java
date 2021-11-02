/*https://leetcode.com/problems/count-good-meals/*/

class Solution {
    public int countPairs(int[] deliciousness) {
        int[] twoPowers = new int[22];
        for (int j = 0; j <= 21; ++j)
            twoPowers[j] = (int)Math.pow(2,j);
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        int result = 0;
        for (int i = 0; i < deliciousness.length; ++i)
        {
            for (int j = 0; j < twoPowers.length; ++j)
            {
                if (map.containsKey(twoPowers[j]-deliciousness[i]))
                    result = (result+(Integer)map.get(twoPowers[j]-deliciousness[i]))%1000000007;
            }
            map.put(deliciousness[i],map.containsKey(deliciousness[i])?(Integer)map.get(deliciousness[i])+1:1);
        }
        return result;
    }
}