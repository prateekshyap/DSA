/*https://leetcode.com/problems/find-original-array-from-doubled-array/*/

class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length%2 != 0) return new int[0];
        Arrays.sort(changed);
        int n = changed.length;
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for (int num : changed) map.put(num,map.getOrDefault(num,0)+1);
        int[] result = new int[n/2];
        int index = 0;
        while (!map.isEmpty())
        {
            int num = (Integer)map.firstKey();
            if (!map.containsKey(num*2)) return new int[0];
            result[index++] = num;
            map.put(num,map.get(num)-1);
            if (map.get(num) == 0) map.remove(num);
            num *= 2;
            if (!map.containsKey(num)) return new int[0];
            map.put(num,map.get(num)-1);
            if (map.get(num) == 0) map.remove(num);
        }
        return result;
    }
}

class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length%2 != 0) return new int[0];
        int n = changed.length;
        int max = 0;
        for (int num : changed)
            if (num > max)
                max = num;
        if (max%2 != 0) return new int[0];
        int[] map = new int[max+1];
        for (int num : changed) ++map[num];
        int[] result = new int[n/2];
        int index = 0;
        for (int i = 0; i <= max; ++i)
        {
            if (map[i] == 0) continue;
            if (2*i > max || map[2*i] == 0) return new int[0];
            result[index++] = i;
            --map[i];
            if (map[2*i] == 0) return new int[0];
            --map[2*i];
            if (map[i] > 0) --i;
        }
        return result;
    }
}