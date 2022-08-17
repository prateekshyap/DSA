/*https://leetcode.com/problems/redundant-connection-ii/*/

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n= edges.length;
        int[] parent= new int[n+1];
        Arrays.fill(parent,-1);
        int[] ds= new int[n+1];
        int first=-1,second=-1,last=-1;
        for(int i=0;i<n;i++)
        {
            int p= edges[i][0];
            int c= edges[i][1];
            if(parent[c]!=-1)
            {
                first=parent[c];
                second=i;
                continue;
            }
            parent[c]=i;
            // Now detect cycles
            int p1= find(ds,p);
            if(p1==c) // cycle detected
            {
                last=i;
            }
            else
            {
                ds[c]=p1;
            }  
        }
        
        if(second==-1)
        {
            return edges[last];
        }
        else if(last==-1)
        {
            return edges[second];
        }
        else
        {
            return edges[first];
        }
        
    }
    public int find(int[] ds, int i)
    {
        return ds[i]==0 ? i : (ds[i]=find(ds,ds[i]));
    }
}

class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        Arrays.fill(parent, -1);
        
        boolean twoParent = false;
        int[] e1 = null;
        int[] e2 = null;
        for(int[] edge : edges) {
            int p = edge[0];
            int c = edge[1];
            
            if(parent[c] == -1) {
                parent[c] = p;
            } else {
                twoParent = true;
                e2 = edge;
                e1 = new int[] {parent[c], c};
                break;
            }
        }
         
        dsu = new int[edges.length + 1];
        for(int i=0; i<dsu.length; i++) {
            dsu[i] = i;
        }
        
        if(!twoParent) {
            // edge creating the cycle is the answer
            for(int[] edge : edges) {
                int pl = find(edge[0]);
                int cl = find(edge[1]);
                
                if(pl != cl) {
                    dsu[cl] = pl;
                } else {
                    return edge;
                }
            }
        } else {
            // check for cycle
            boolean noCycle = true;
            for(int[] edge : edges) {
                if(edge != e2) {
                    int pl = find(edge[0]);
                    int cl = find(edge[1]);

                    if(pl != cl) {
                        dsu[cl] = pl;
                    } else {
                        //cycle
                        noCycle = false;
                        break;
                    }   
                }
            }
            
            if(noCycle) {
                return e2;
            } 
        }
        
        return e1;
    }
    
    public int[] dsu;
    
    public int find(int x) {
        if(dsu[x] == x) {
            return x;
        } else {
            dsu[x] = find(dsu[x]);
            return dsu[x];
        }
    }
   
}