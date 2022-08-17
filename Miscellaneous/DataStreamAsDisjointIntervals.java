/*https://leetcode.com/problems/data-stream-as-disjoint-intervals/*/

class SummaryRanges {
    List<List<Integer>> intervals;
    HashSet<Integer> set;
    public SummaryRanges() {
        intervals = new ArrayList<List<Integer>>();
        set = new HashSet<Integer>();
    }
    
    public void addNum(int val) {
        if (set.contains(val)) return;
        set.add(val);
        List<Integer> interval;
        int i = -1;
        for (i = 0; i < intervals.size(); ++i)
        {
            interval = intervals.get(i);
            if (val == interval.get(0)-1 || val == interval.get(1)+1)
                break;
        }
        if (intervals.size() == 0)
            intervals.add(Arrays.asList(val,val));
        else if (i == intervals.size())
            intervals.add(Arrays.asList(val,val));
        else
        {
            interval = intervals.get(i);
            if (val == interval.get(0)-1)
            {
                interval.set(0,val);
                if (i != 0 && intervals.get(i-1).get(1) == val-1)
                {
                    interval.set(0,intervals.get(i-1).get(0));
                    intervals.remove(i-1);
                }
            }
            else if (val == interval.get(1)+1)
            {
                interval.set(1,val);
                if (i != intervals.size()-1 && intervals.get(i+1).get(0) == val+1)
                {
                    interval.set(1,intervals.get(i+1).get(1));
                    intervals.remove(i+1);
                }
            }
            else intervals.add(Arrays.asList(val,val));
        }
        Collections.sort(intervals,(a,b)->(a.get(0)-b.get(0)));
    }
    
    public int[][] getIntervals() {
        int[][] result = new int[intervals.size()][2];
        for (int i = 0; i < result.length; ++i)
        {
            result[i][0] = intervals.get(i).get(0);
            result[i][1] = intervals.get(i).get(1);
        }
        return result;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */