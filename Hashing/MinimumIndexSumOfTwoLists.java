/*https://leetcode.com/problems/minimum-index-sum-of-two-lists/*/

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for (int i = 0; i < list1.length; ++i)
            map.put(list1[i],i);
        int min = list1.length+list2.length+1;
        List<String> resultList = new ArrayList<String>();;
        for (int i = 0; i < list2.length; ++i)
        {
            if (map.containsKey(list2[i]))
            {
                int val = (Integer)map.get(list2[i]);
                if (val+i < min)
                {
                    min = val+i;
                    resultList = new ArrayList<String>();
                    resultList.add(list2[i]);
                }
                else if (val+i == min)
                    resultList.add(list2[i]);
            }
        }
        String[] result = new String[resultList.size()];
        for (int i = 0; i < result.length; ++i)
            result[i] = (String)resultList.get(i);
        return result;
    }
}