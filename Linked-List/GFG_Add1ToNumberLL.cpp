/*
https://practice.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1#
Add 1 to a number represented as linked list 
*/

// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h> 
using namespace std; 

struct Node
{
    int data;
    struct Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
};

void printList(Node* node) 
{ 
    while (node != NULL) { 
        cout << node->data; 
        node = node->next; 
    }  
    cout<<"\n";
} 


 // } Driver Code Ends
//User function template for C++

/* 

struct Node
{
    int data;
    struct Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
};

*/

class Solution
{
    public:
    
    Node* reverse(Node* l1)
    {
        Node* prev=nullptr, *cnxt, *cur = l1;
        while(cur)
        {
            cnxt = cur->next;
            cur->next = prev;
            prev = cur;
            cur = cnxt;
        }
        return prev;
    }
    
    Node* addOne(Node *head) 
    {
        Node* l1 = reverse(head);
        
        int carry=1;;
        
        Node *cur = nullptr;
        
        while(l1)
        {
            carry+=l1->data;
            l1=l1->next;
           
            Node* newptr = new Node(carry%10);
            newptr->next = cur;
            cur = newptr;
            carry = carry/10;
        }
        if(carry)
            {
                Node* newptr = new Node(carry);
                newptr->next = cur;
                cur = newptr;
            }
        
        return cur;
    }
};

// { Driver Code Starts.

int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        string s;
        cin>>s;
        
        Node* head = new Node( s[0]-'0' );
        Node* tail = head;
        for(int i=1; i<s.size(); i++)
        {
            tail->next = new Node( s[i]-'0' );
            tail = tail->next;
        }
        Solution ob;
        head = ob.addOne(head);
        printList(head); 
    }
    return 0; 
} 
  // } Driver Code Ends