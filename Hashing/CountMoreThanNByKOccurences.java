/*https://practice.geeksforgeeks.org/problems/count-element-occurences/1/*/

class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
        // your code here,return the answer
        int count = 0;
        double ratio = (double)n/(double)k;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int num : arr)
            map.put(num,map.containsKey(num) ? (Integer)map.get(num)+1 : 1);
        for (Map.Entry elem : map.entrySet())
            if ((Integer)elem.getValue() > ratio) ++count;
        return count;
    }
}
