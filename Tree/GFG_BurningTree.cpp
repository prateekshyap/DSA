/*
https://practice.geeksforgeeks.org/problems/burning-tree/1
Burning Tree
*/

class Solution {
  public:
  /*
   int minTime(Node* root, int target) 
    {
        unordered_map<Node*, Node*> um;
        Node* tarnode = map_child_par(root, um, target);
        int time = func(um, tarnode);
        return time;
    }
    Node* map_child_par(Node* root, unordered_map<Node*, Node*> &um, int tg)
    {
        queue<Node*> q;        q.push(root);
        Node* tarnodeptr;
        while(!q.empty())
        {
            Node* cur = q.front(); q.pop();
            if(cur->data == tg) tarnodeptr = cur;
            if(cur->left)
            {
                um[cur->left] = cur;
                q.push(cur->left);
            }
            if(cur->right)
            {
                um[cur->right] =cur;
                q.push(cur->right);
            }
        }
        return tarnodeptr;
    }
    int func(unordered_map<Node*, Node*> &par, Node* tg)
    {
        int time=0;
        unordered_map<Node* , bool> visit;
        queue<Node*> q; q.push(tg);
        visit[tg] = true;
        while(!q.empty())
        {
            int sz = q.size();
            bool check = false;
            while(sz--)
            {
                Node* cur = q.front(); q.pop();
                if(cur->left and !visit[cur->left])
                {
                    check = true;
                    visit[cur->left] = true;
                    q.push(cur->left);
                }
                if(cur->right and !visit[cur->right])
                {
                    check = true;
                    visit[cur->right] = true;
                    q.push(cur->right);
                }
                if(par[cur] and !visit[par[cur]])
                {
                    check = true;
                    visit[par[cur]] = true;
                    q.push(par[cur]);
                }
                
            }
            if(check) time++;
        }
        return time;
    }
    */
//   /*
    int time=0;
    int tg=0;
    int minTime(Node* root, int target) 
    {
        tg = target;
        burnDfs(root);
        return time;
    }
    
    pair<int, bool> burnDfs (Node* root){
        if(!root) return {0, false};
        
        pair<int, bool> left, right; 
        if(root->left) left = burnDfs(root->left);
        else left = {0, false};
        if(root->right)   right = burnDfs(root->right);
        else right = {0, false};
        
        // myprint({root->data, left.first, right.first, (left.second), (right.second), time});
        if(root->data == tg){
            time = max(left.first, right.first);
            return {1, true};
        }
        
        if(left.second)
        {
            time = max(time, right.first + left.first);
            return {left.first + 1, true};
        }
        if(right.second)
        {
            time = max(time, right.first + left.first);
            return {right.first + 1, true};
        }
        
        return { 1 + max(left.first, right.first), false};
    }
    
  void myprint(vector<int> vec) { for(int x: vec)  cout<<x<<" "; cout<<endl; }
    // */
};