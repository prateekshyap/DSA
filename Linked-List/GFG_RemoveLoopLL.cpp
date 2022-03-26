/* 
 *	https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
 *  Remove loop in Linked List 
 */
 
 // { Driver Code Starts
// driver code

#include <iostream>
using namespace std;

struct Node
{
    int data;
    Node* next;
    
    Node(int val)
    {
        data = val;
        next = NULL;
    }
};

void loopHere(Node* head, Node* tail, int position)
{
    if(position==0) return;
    
    Node* walk = head;
    for(int i=1; i<position; i++)
        walk = walk->next;
    tail->next = walk;
}

bool isLoop(Node* head)
{
    if(!head) return false;
    
    Node* fast = head->next;
    Node* slow = head;
    
    while( fast != slow)
    {
        if( !fast || !fast->next ) return false;
        fast=fast->next->next;
        slow=slow->next;
    }
    
    return true;
}

int length(Node* head)
{
    int ret = 0;
    while(head)
    {
        ret++;
        head = head->next;
    }
    return ret;
}


 // } Driver Code Ends
/*
structure of linked list node:

struct Node
{
    int data;
    Node* next;
    
    Node(int val)
    {
        data = val;
        next = NULL;
    }
};

*/

class Solution
{
    public:
    //Function to remove a loop in the linked list.
    void removeLoop(Node* head)
    {
        // code here
        // just remove the loop without losing any nodes
        
        // if empty LL or one node or two node without cycle.
        if(!head || !head->next || !head->next->next) return ;
        
        
        Node* slow = head, *fast = head;
        Node* deln = head;
        
        slow = slow->next;
        fast = fast->next->next;
        deln = deln->next; // just behind fast node
        
        // if(head->next == head)
        // {
        //     head->next == nullptr;
        //     return;
        // }
        
        while(slow && fast && fast->next)
        {
            if(slow == fast) break;
            slow = slow->next;
            
            deln = fast;
            deln = deln->next ;// just behind fast node
            
            fast = fast->next->next;
        }
        
        // if no loop exists
        if(slow != fast) return; //|| !fast || !fast->next
        
        // if loop exists
        slow = head; // start from head node
        // if(slow == fast) // loop at begining of head node
            
        while(slow != fast)
        {
            slow = slow->next;
            deln = fast;
            fast = fast->next;
            
        }
        
        deln->next = nullptr;
        
        return;
    }//end
};

// { Driver Code Starts.

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n, num;
        cin>>n;
        
        Node *head, *tail;
        cin>> num;
        head = tail = new Node(num);
        
        for(int i=0 ; i<n-1 ; i++)
        {
            cin>> num;
            tail->next = new Node(num);
            tail = tail->next;
        }
        
        int pos;
        cin>> pos;
        loopHere(head,tail,pos);
        
        Solution ob;
        ob.removeLoop(head);
        
        if( isLoop(head) || length(head)!=n )
            cout<<"0\n";
        else
            cout<<"1\n";
    }
	return 0;
}
  // } Driver Code Ends