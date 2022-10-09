/*https://leetcode.com/problems/minimum-time-difference/*/

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int[][] times = new int[timePoints.size()][2];
        int i = 0;
        for (String timePoint : timePoints)
        {
            String[] hm = timePoint.split("[:]");
            times[i][0] = Integer.parseInt(hm[0]);
            times[i][1] = Integer.parseInt(hm[1]);
            ++i;
        }
        Arrays.sort(times,new Comparator<int[]>()
        {
            public int compare(int[] time1, int[] time2)
            {
                if (time1[0] == time2[0] && time1[1] == time2[1]) return 0;
                if (time1[0] > time2[0] || (time1[0] == time2[0] && time1[1] > time2[1])) return 1;
                else return -1;
            }
        });
        int result = 1440;
        for (i = 0; i < times.length-1; ++i)
        {
            int[] time1 = times[i];
            int[] time2 = times[i+1];
            int diff = 0;
            if (time1[0] > time2[0] || (time1[0] == time2[0] && time1[1] > time2[1]))
            {
                diff += 60*(time1[0]-time2[0]);
                diff += time1[1]-time2[1];
            }
            else
            {
                diff += 60*(time2[0]-time1[0]);
                diff += time2[1]-time1[1];
            }
            diff = Math.min(diff,1440-diff);
            result = Math.min(result,diff);
            if (result == 0) return 0;
        }
        int[] time1 = times[0];
        int[] time2 = times[times.length-1];
        int diff = 0;
        if (time1[0] > time2[0] || (time1[0] == time2[0] && time1[1] > time2[1]))
        {
            diff += 60*(time1[0]-time2[0]);
            diff += time1[1]-time2[1];
        }
        else
        {
            diff += 60*(time2[0]-time1[0]);
            diff += time2[1]-time1[1];
        }
        diff = Math.min(diff,1440-diff);
        result = Math.min(result,diff);
        return result;
    }
}

class Solution {
    public int findMinDifference(List<String> timePoints) {
        int T = timePoints.size();
        int[] minutes = new int[T];
        for (int i = 0; i < T; ++i)
        {
            String hm = timePoints.get(i);
            int h = (hm.charAt(0)-'0')*10+(hm.charAt(1)-'0');
            int m = (hm.charAt(3)-'0')*10+(hm.charAt(4)-'0');
            minutes[i] = h*60+m;
        }
        boolean[] presence = new boolean[1440];
        for (int i = 0; i < T; ++i)
        {
            if (presence[minutes[i]]) return 0;
            presence[minutes[i]] = true;
        }
        int result = 1440, i = 0, prev = -1, curr = -1, first = -1;
        while (i < 1440)
        {
            if (presence[i])
            {
                if (first == -1) first = i;
                prev = curr;
                curr = i;
                if (prev == -1)
                {
                    ++i;
                    continue;
                }
                result = Math.min(result,curr-prev);
            }
            ++i;
        }
        result = Math.min(result,1440+first-curr);
        result = Math.min(result,curr-first);
        return result;
    }
}