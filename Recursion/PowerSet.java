/*https://practice.geeksforgeeks.org/problems/power-set4302/1*/

class Solution
{
    List<String> result;
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        result = new ArrayList<String>();
        recur(s.toCharArray(),0,s.length(),new StringBuffer(""));
        Collections.sort(result);
        return result;
    }
    public void recur(char[] arr, int index, int n, StringBuffer curr)
    {
        if (index == n)
        {
            if (curr.length() > 0) result.add(new String(curr));
            return;
        }
        
        recur(arr,index+1,n,curr);
        curr.append(arr[index]);
        recur(arr,index+1,n,curr);
        curr.delete(curr.length()-1,curr.length());
    }
}