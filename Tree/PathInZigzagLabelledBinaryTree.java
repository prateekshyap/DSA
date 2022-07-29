/*https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/*/

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        double val = (Math.log(label)/Math.log(2));
        int level = (int)Math.ceil(val);
        if (Math.ceil(val) == val)
            ++level;
        int[] LtoR = new int[level], RtoL = new int[level];
        int copy = label, i = 0;
        while (copy > 0)
        {
            LtoR[i++] = copy;
            copy /= 2;
        }
        copy = 3*(int)Math.pow(2,level-1)-1-label;
        i = 0;
        while (copy > 0)
        {
            RtoL[i++] = copy;
            copy /= 2;
        }
        List<Integer> path = new ArrayList<Integer>();
        boolean flag = true;
        for (i = 0; i < level; ++i)
        {
            if (flag)
                path.add(0,LtoR[i]);
            else path.add(0,RtoL[i]);
            flag = !flag;
        }
        return path;
    }
}

class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        double val = (Math.log(label)/Math.log(2));
        int level = (int)Math.ceil(val);
        if (Math.ceil(val) == val)
            ++level;
        List<Integer> path = new ArrayList<Integer>();
        int curr = label, i;
        for (i = level-1; i >= 0; --i)
        {
            if (i%2 == level%2)
            {
                path.add(0,3*(int)Math.pow(2,i)-1-curr);
            }
            else path.add(0,curr);
            curr /= 2;
        }
        return path;
    }
}