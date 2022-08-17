/* https://leetcode.com/problems/clone-graph/
https://practice.geeksforgeeks.org/problems/clone-graph/0
 * Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 */

#include<bits/stdc++.h>
using namespace std;

// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};


class Solution {
public:

    Node* cloneGraph(Node* gnode) {
        if(!gnode) return nullptr;

        //USING BFS
        // return bfsCloneGraph(gnode);

        //USING DFS
        unordered_map<Node*, Node*> cm;
        dfsCloneGraph(gnode, cm);
        return cm[gnode];

    }//cloneGraph()


    Node* bfsCloneGraph(Node *g){
        // if(!g) return nullptr;      // if graph is null then return;

        unordered_map<Node *, Node*> cm;      //cloned map (orig, cloned)   unordered map (unique keys)
        queue<Node *> q;            // for BFS Traversal

        Node *cg = new Node(g->val); //creating new clone node

        cm.insert({g, cg});     // cm[g] = cg;
        q.push(g);

        while(!q.empty()){
            Node *s = q.front(); q.pop();

            // iterate over all children of the node s. Node *w =
            for(auto w: s->neighbors){

                // if node is not created ie not visited yet
                if(!cm[w]){
                    cg = new Node(w->val);
                    cm[w] = cg;
                    q.push(w);
                }
                // add the nodes to the adj list of new node.
                cm[s]->neighbors.push_back(cm[w]);
            }//for w

        }// while q

        return cm[g]; // that is source cloned map
    } //bfsCloneGraph

    void dfsCloneGraph(Node *g, unordered_map<Node*, Node*> &cm){

        // if node is created ie already visited
        if(cm[g]) return;

        cm[g] = new Node(g->val);

        for (auto w: g->neighbors)
            dfsCloneGraph(w, cm);
        for (auto w: g->neighbors)
            cm[g]->neighbors.push_back(cm[w]);


    }//dfsCloneGraph

};