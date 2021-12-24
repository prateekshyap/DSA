/*https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays/1*/

/*Prateekshya's Solution*/

class Solution
{
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
        for (int i = 0; i < n; ++i)
            map.put(arr1[i],true);
        for (int i = 0; i < m; ++i)
            map.put(arr2[i],true);
        ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
        Collections.sort(list);
        return list;
    }
}
/*Pratik's Solution*/

class Solution
{
    //Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int a = 0 , b = 0;
        if(arr1[a]<arr2[b])
        {
            al.add(arr1[a]);
            a++;
        }
        else if(arr1[a]>arr2[b])
        {
            al.add(arr2[b]);
            b++;
        }
        else
        {
            al.add(arr1[a]);
            a++;
            b++;
        }
        for(int i=1;i<(m+n);i++)
        {
            if(a>=n || b>=m)break;
            if(arr1[a]>arr2[b])
            {
                if(al.get(al.size()-1)!=arr2[b])
                al.add(arr2[b]);
                b++;
            }
            else if(arr1[a]<arr2[b])
            {
                if(al.get(al.size()-1)!=arr1[a])
                al.add(arr1[a]);
                a++;
            }
            else if(arr1[a]==arr2[b])
            {
                if(al.get(al.size()-1)!=arr1[a])
                al.add(arr2[b]);
                a++;
                b++;
            }
            //System.out.println(i+" "+(m+n));
        }
        //System.out.println(a+" "+b);
        if(a>=n)
        {
            for(int i=b;i<m;i++)
            {
                if(al.get(al.size()-1)<arr2[i])al.add(arr2[i]);
            }
        }
        else if(b>=m)
        {
            for(int i=a;i<n;i++)
            {
                if(al.get(al.size()-1)<arr1[i])al.add(arr1[i]);
            }
        }
        return al;
    }
}