/*https://practice.geeksforgeeks.org/problems/repetition-of-k-length-substring/1*/

class GfG
{
    public static boolean checkString(String str, int k)
    {
        int n = str.length();
        if (n%k != 0) return false;
         
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (int i = 0; i < n; i += k)
        {
            if (map.containsKey(str.substring(i,i+k)))
                map.put(str.substring(i,i+k),((Integer)map.get(str.substring(i,i+k)))+1);
            else
                map.put(str.substring(i,i+k), 1);
        }
        
        if (map.size() == 1) return true;
        if (map.size() != 2) return false;
        
        Iterator<Map.Entry<String,Integer>> itr = map.entrySet().iterator();
        Map.Entry<String,Integer> entry = itr.next();
        if (entry.getValue() == (n/k - 1) || entry.getValue() == 1) return true;
        return false;
    }
}