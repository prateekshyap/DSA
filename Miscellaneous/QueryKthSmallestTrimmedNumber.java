/*https://leetcode.com/problems/query-kth-smallest-trimmed-number/*/

class Pair implements Comparable<Pair>
{
    String a;
    int b;
    Pair(String a, int b)
    {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public int compareTo(Pair p)
    {
        return this.a.compareTo(p.a);
    }
    
    @Override
    public String toString()
    {
        return "("+a+","+b+")";
    }
}
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        HashMap<Integer,ArrayList<Pair>> map = new HashMap<Integer,ArrayList<Pair>>();
        StringBuilder[] build = new StringBuilder[nums.length];
        for (int i = 0; i < nums.length; ++i) build[i] = new StringBuilder("");
        int max = Integer.MIN_VALUE;
        for (int[] query : queries)
            if (query[1] > max)
                max = query[1];
        int len = nums[0].length();
        ArrayList<Pair> list;
        for (int trim = 1; trim <= max; ++trim)
        {
            for (int i = 0; i < nums.length; ++i)
                build[i].insert(0,nums[i].charAt(len-trim));
            list = new ArrayList<Pair>();
            for (int i = 0; i < nums.length; ++i)
                list.add(new Pair(build[i].toString(),i));
            Collections.sort(list);
            map.put(trim,list);
        }
        
        int i = 0;
        Pair res;
        for (int[] query : queries)
        {
            list = (ArrayList)map.get(query[1]);
            res = (Pair)list.get(query[0]-1);
            result[i] = res.b;
            i++;
        }
        
        return result;
    }
}

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int [] result = new int [queries.length];
        
        int idx = 0;
        
        Num [] numbers = new Num[nums.length];
        Num current;
        
        for (int [] query : queries){
            for (int i = 0; i < nums.length; ++i){
                current = new Num();
                current.index = i;
                current.digits = nums[i].substring(nums[i].length() - query[1]);
                numbers[i] = current;
            }
            
            Arrays.sort(numbers, (a , b) -> a.digits.compareTo(b.digits));
            
            result[idx++] = numbers[query[0] - 1].index;
        }
        
        return result;
    }
}
class Num{
    String digits;
    int index;
    
}