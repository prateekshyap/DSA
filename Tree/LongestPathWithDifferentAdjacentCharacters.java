/*https://leetcode.com/problems/longest-path-with-different-adjacent-characters/*/

class Solution {
    int ans=1;
    public int trav(List<List<Integer>>list,int i,String s)
    {
        int max[]=new int[2];
        for(Integer j: list.get(i))
        {
            int c=trav(list,j,s);
            if(s.charAt(i)!=s.charAt(j))
            {
                if(max[0]<=c)
                {
                    max[1]=max[0];
                    max[0]=c;
                }
                else
                    max[1]=Math.max(c,max[1]);
            }
        }
        ans=Math.max(1+max[0]+max[1],ans);
        return 1+max[0];
    }
    public int longestPath(int[] parent, String s) {
        List<List<Integer>>list=new ArrayList<>();
        for(int i=0;i<parent.length;i++)
        {
            List<Integer>temp=new ArrayList<>();
            list.add(temp);
        }
        for(int i=0;i<parent.length;i++)
        {
            if(parent[i]!=-1)
                list.get(parent[i]).add(i);
        }
        trav(list,0,s);
        return ans;
    }
}