/*https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/*/

/*My Approach*/
class Solution {
    public int numPairsDivisibleBy60(int[] time) 
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<time.length;i++)
        {
            if(map.containsKey(time[i]%60))
            {
                map.put(time[i]%60,map.get(time[i]%60)+1);
            }
            else
            {
                map.put(time[i]%60,1);
            }
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()==0)continue;
            int i = entry.getKey();
            int c = entry.getValue();
            if(i==0||i==30)count+=(c*(c-1)/2);
            else
            {
                if(map.containsKey(60-i))
                {
                    int d = map.get(60-i);
                    //System.out.println(i+" "+c+" "+d);
                    count += (c*d);
                    map.put(60-i,0);
                    map.put(i,0);
                }
            }
        }
        return count;
    }
}
/*Same logic but used array so efficient*/
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] freq = new int[60];
        
        for (int i = 0; i < time.length; i++) {
            time[i] = time[i] % 60;
        }
        
        for (int i = 0; i < time.length; i++) {
            freq[time[i]] = freq[time[i]] + 1;
        }
        int count = 0;
        for (int i = 0; i <= 30; i++) {
            if (i == 0 || i == 30) {
                count += (freq[i] * (freq[i] - 1)) / 2;
            } else
                count = count + (freq[i] * freq[60-i]);
        } 
        return count;
    }
}