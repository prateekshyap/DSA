/*https://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency-1587115621/1*/

class FrequencyComparator implements Comparator<ArrayList<Integer>>
{
    @Override
    public int compare(ArrayList<Integer> list1, ArrayList<Integer> list2)
    {
        int i1 = (Integer)list1.get(1);
        int i2 = (Integer)list2.get(1);
        if (i1 > i2) return -1;
        if (i1 < i2) return 1;
        int i3 = (Integer)list1.get(0);
        int i4 = (Integer)list2.get(0);
        if (i3 < i4) return -1;
        return 1;
    }
}

class Solution
{
    //Function to sort the array according to frequency of elements.
    static ArrayList<Integer> sortByFreq(int arr[], int n)
    {
        // add your code here
        PriorityQueue<ArrayList<Integer>> heap = new PriorityQueue<ArrayList<Integer>>(new FrequencyComparator());
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < n; ++i)
            map.put(arr[i],(map.containsKey(arr[i]) ? (Integer)map.get(arr[i])+1 : 1));
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry element = (Map.Entry)iterator.next();
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            tempList.add((Integer)element.getKey());
            tempList.add((Integer)element.getValue());
            heap.add(tempList);
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        while (!heap.isEmpty())
        {
            ArrayList<Integer> tempList = heap.poll();
            int loop = (Integer)tempList.get(1);
            int elem = (Integer)tempList.get(0);
            for (int i = 0; i < loop; ++i)
                result.add(elem);
        }
        return result;
    }
}