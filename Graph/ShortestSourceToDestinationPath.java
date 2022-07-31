/*https://practice.geeksforgeeks.org/problems/shortest-source-to-destination-path3544/1/*/

class Solution {
    class Node
    {
        int x,y,count;
        Node(int x,int y,int count)
        {
            this.x=x;
            this.y=y;
            this.count=count;
        }
    }
    
    int shortestDistance(int N, int M, int A[][], int X, int Y) 
    {
        if(A[0][0]==0)
        return -1;

        Queue<Node> q=new LinkedList<>();
        
        q.offer(new Node(0,0,0));
        int dirx[]={1,-1,0,0};
        int diry[]={0,0,-1,1};
        boolean visited[][]=new boolean[N][M];
        
        while(q.size()>0)
        {
            Node nd=q.remove();
            
            if(nd.x==X&&nd.y==Y)
                return nd.count;
            
            for(int i=0;i<dirx.length;i++)
            {
                int x=nd.x+dirx[i];
                int y=nd.y+diry[i];
                
                if(x>=A.length||x<0||y>=A[0].length||y<0||visited[x][y])
                continue;
                
                visited[x][y]=true;
                if(A[x][y]==1)
                q.offer(new Node(x,y,nd.count+1));
            }
        }
        return -1;
    }
}