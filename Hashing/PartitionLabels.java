/*https://leetcode.com/problems/partition-labels/*/

class Solution {
    public List<Integer> partitionLabels(String s) {
        int i, n = s.length();
        char[] a = s.toCharArray();
        int[] lastOcc = new int[26];
        List<Integer> list = new ArrayList<Integer>();
        Arrays.fill(lastOcc, -1);
        for (i = 0; i < n; ++i) lastOcc[a[i]-'a'] = i;
        int count = 0, start = 0, end = 0;
        i = start;
        while (i < n)
        {
            end = Math.max(end,lastOcc[a[i]-'a']);
            if (i == end)
            {
                list.add(end-start+1);
                start = end = i+1;
                i = start;
            }
            else ++i;
        }
        return list;
    }
}