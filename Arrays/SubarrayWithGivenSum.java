/*https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1*/

/*Prateekshya's Solution*/
class Solution
{
    static ArrayList<Integer> list;
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        list = new ArrayList<Integer>();
        
        //create hashtable
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int sum = 0;
        
        map.put(0,-1);
        for (int i = 0; i < n; ++i)
        {
            //get the sum till current point
            sum += arr[i];
            
            //check if the required sum is present somewhere
            if (map.containsKey(sum-s))
            {
                list.add((Integer)map.get(sum-s)+2);
                list.add(i+1);
                return list;
            }
            
            //add to the hashtable
            map.put(sum,i);
        }
        list.add(-1);
        return list;
    }
}

/*Pratik's Solution*/

class Solution
{
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        ArrayList<Integer> al = new ArrayList<Integer>();
        int sum = arr[0];
        int left=0,right=1;
        while(right<n)
        {
            while(right<n && sum<s)
            {
                sum+=arr[right++];
            }
            if(sum==s)
            {
                al.add(left+1);
                al.add(right);
                return al;
            }
            while(left<right && sum>s)
            {
                sum-=arr[left++];
            }
        }
        if(sum==s)
        {
            al.add(left+1);
            al.add(right);
        }
        else
        {
            al.add(-1);
        }
        return al;
    }
}