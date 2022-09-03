/*https://leetcode.com/problems/binary-watch/*/

class Solution {
    boolean[] hours, mins;
    int[] hourMap = new int[]{1,2,4,8}, minMap = new int[]{1,2,4,8,16,32};
    List<String> result;
    public List<String> readBinaryWatch(int turnedOn) {
        hours = new boolean[4];
        mins = new boolean[6];
        result = new ArrayList<String>();
        recur(0, 0, 0, turnedOn);
        return result;
    }
    private void recur(int h, int m, int index, int on)
    {
        if (on == 0)
        {
            if (h >= 0 && h <= 11 && m >= 0 && m <= 59)
            {
                StringBuilder time = new StringBuilder("");
                time.append(Integer.toString(h));
                time.append(":");
                if (m <= 9) time.append("0");
                time.append(Integer.toString(m));
                result.add(time.toString());
            }
            return;
        }
        if (index >= 10) return;
        
        if (index <= 3)
        {
            recur(h+hourMap[index],m,index+1,on-1);
            recur(h,m,index+1,on);
        }
        else if (index <= 9)
        {
            recur(h,m+minMap[index-4],index+1,on-1);
            recur(h,m,index+1,on);
        }
    }
}