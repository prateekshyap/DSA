/*https://practice.geeksforgeeks.org/problems/common-elements1132/1*/

class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        ArrayList<Integer> list = new ArrayList<>();

        //store elements of first array with value 1
        for (int i = 0; i < n1; ++i)
            map.put(A[i],1);

        //add 2 to all the elements who have value 1
        for (int j = 0; j < n2; ++j)
            if (map.containsKey(B[j]) && (Integer)map.get(B[j]) == 1)
                map.put(B[j],map.get(B[j])+2);
            else if (map.containsKey(B[j]) && (Integer)map.get(B[j]) != 3)
                map.put(B[j],2);

        //add 4 to all the elements who have value 3
        for (int k = 0; k < n3; ++k)
            if (map.containsKey(C[k]) && ((Integer)map.get(C[k]) == 1 || (Integer)map.get(C[k]) == 3))
                map.put(C[k],map.get(C[k])+4);
            else if (map.containsKey(C[k]) && (Integer)map.get(C[k]) != 7)
                map.put(C[k],4);

        //retrieve only those elements who have value 7
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry mapElement = (Map.Entry)iterator.next();
            if ((Integer)mapElement.getValue() == 7)
                list.add((Integer)mapElement.getKey());
        }
        Collections.sort(list);
        return list;
    }
}