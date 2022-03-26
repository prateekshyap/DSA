/* https://practice.geeksforgeeks.org/problems/rotate-a-linked-list/1
 * Reverse Linked List
 */
 // { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    struct Node *next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};


 // } Driver Code Ends
/*

struct Node {
    int data;
    struct Node *next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};

*/


class Solution
{
    public:
    //Function to rotate a linked list.
    Node* rotate(Node* head, int k)
    {
        Node* ptr = head, *prev = nullptr;
        Node* oldHead = head;
        
        while(k--)
        {
            prev = ptr;
            ptr = ptr->next;
        }
        
        if(prev->next == nullptr) return oldHead;
        
        prev->next = nullptr;
        head = ptr;
        
        
        while(ptr->next)
        {
            ptr = ptr->next;
        }
        
        ptr->next = oldHead;
        
        return head;
    }//end
};
    


// { Driver Code Starts.

void printList(Node *n)
{
    while (n != NULL)
    {
        cout<< n->data << " ";
        n = n->next;
    }
    cout<< endl;
}

int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n, val, k;
        cin>>n;
        
        cin>> val;
        Node *head = new Node(val);
        Node *tail = head;
        
        for(int i=0; i<n-1; i++)
        {
            cin>> val;
            tail->next = new Node(val);
            tail = tail->next;
        }
        
        cin>> k;
        
        Solution ob;
        head = ob.rotate(head,k);
        printList(head);
    }
    return 1;
}
  // } Driver Code Ends