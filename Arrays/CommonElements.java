/*https://practice.geeksforgeeks.org/problems/common-elements1132/1*/

/*Prattekshya's Solution*/

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

/*Without extra space with three pointers*/
class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        // code here 
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int i1 = 0, i2 = 0, i3 = 0, min = 0, minArr = -1;
        while (i1 < n1 && i2 < n2 && i3 < n3)
        {
            if (A[i1] == B[i2] && A[i1] == C[i3])
            {
                if (list.size() == 0 || list.get(list.size()-1) != A[i1]) list.add(A[i1]);
                ++i1; ++i2; ++i3;
                continue;
            }
            min = A[i1]; minArr = 1;
            if (B[i2] < min)
            {
                min = B[i2];
                minArr = 2;
            }
            if (C[i3] < min)
            {
                min = C[i3];
                minArr = 3;
            }
            
            if (minArr == 1) ++i1;
            else if (minArr == 2) ++i2;
            else ++i3;
        }
        
        return list;
    }
}

/* Pratik's Solution */
class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        // code here 
        ArrayList<Integer> al = new ArrayList<Integer>();
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<n1;i++)
        {
            if(!map.containsKey(A[i]))map.put(A[i],1);
        }
        for(int i=0;i<n2;i++)
        {
            if(map.containsKey(B[i]))map.put(B[i],2);
        }
        for(int i=0;i<n3;i++)
        {
            if(map.containsKey(C[i]) && map.get(C[i])==2)
            {
                map.put(C[i],3);
                al.add(C[i]);
            }
        }
        return al;
    }
}