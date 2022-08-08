/*https://leetcode.com/problems/merge-similar-items/*/

class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int[] item : items1)
            map.put(item[0],map.getOrDefault(item[0],0)+item[1]);
        for (int[] item : items2)
            map.put(item[0],map.getOrDefault(item[0],0)+item[1]);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (Map.Entry elem : map.entrySet())
        {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add((Integer)elem.getKey());
            temp.add((Integer)elem.getValue());
            result.add(temp);
        }
        Collections.sort(result,(a,b)->(a.get(0)-b.get(0)));
        return result;
    }
}