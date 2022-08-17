/*
https://practice.geeksforgeeks.org/problems/intersection-of-two-linked-list/1#
Intersection of Two Linked Lists 
*/

// { Driver Code Starts
//

#include <bits/stdc++.h>
using namespace std;

struct Node
{
    int data;
    Node *next;
    Node(int val)
    {
        data=val;
        next=NULL;
    }
};

Node* inputList(int size)
{
    Node *head, *tail;
    int val;
    
    cin>>val;
    head = tail = new Node(val);
    
    while(--size)
    {
        cin>>val;
        tail->next = new Node(val);
        tail = tail->next;
    }
    
    return head;
}

void printList(Node* n)
{
    while(n)
    {
        cout<< n->data << " ";
        n = n->next;
    }
}


 // } Driver Code Ends
/* structure of list node:

struct Node
{
    int data;
    Node *next;
    Node(int val)
    {
        data=val;
        next=NULL;
    }
};

*/

class Solution{
  public:
    Node* findIntersection(Node* h1, Node* h2)
    {
        unordered_map<int,int> um;
        Node* head = new Node(0);
        Node* ptr  = head, * newptr;
        
        while(h2) //h2 for order
        {
            um[h2->data]++;
            h2 = h2->next;
        }
        
        while(h1)
        {
            if(um.find(h1->data) != um.end())
            {
                newptr = new Node(h1->data);
                ptr -> next = newptr;
                ptr = newptr;
            }
            
            h1 = h1->next;
        }
        
        return head->next;
    }
};

// { Driver Code Starts.

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
	    int n,m;
	    
	    cin>> n;
	    Node* head1 = inputList(n);
	    
	    cin>>m;
	    Node* head2 = inputList(m);
	    Solution obj;
	    Node* result = obj.findIntersection(head1, head2);
	    
	    printList(result);
	    cout<< endl;
	}
	return 0;
}
  // } Driver Code Ends