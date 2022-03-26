/* 
 *	https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1
 *  Segregate even and odd nodes in a Link List 
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
        cout << node->data <<" "; 
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
class Solution{
public:
    Node* divide(int N, Node *head){
      
      if(!head || !head->next) return head;
      
      Node* odd_head = nullptr; //odd list pointer
      Node* even_head = nullptr; //even list pointer
      
      Node* ep = nullptr; //even list pointer
      Node* op = nullptr; //odd list pointer
      Node* ptr = head; 
    
     
       
       for(int i=1; i<=N; i++)
       {
           if(ptr->data % 2) // odd number
           {    
               if(!odd_head) 
              {    
                  odd_head = ptr;
                  op = ptr;
              }
              else
              {
                   op->next = ptr;
                   op = op->next;
              }
           }
           else
           {
               
              if(!even_head) 
              {    
                  even_head = ptr;
                  ep = ptr;
              }
              else
              {
                   ep->next = ptr;
                   ep = ep->next;
              }  
           }
           ptr = ptr->next;
       }
       
        if(ep)
            ep->next = odd_head;
        if(op)
            op->next = nullptr;
        
        if(even_head) return even_head;
        else return odd_head;
    }
};

// { Driver Code Starts.

int main() {
    //code
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        int data;
        cin>>data;
        struct Node *head = new Node(data);
        struct Node *tail = head;
        for (int i = 0; i < N-1; ++i)
        {
            cin>>data;
            tail->next = new Node(data);
            tail = tail->next;
        }
        
        Solution ob;
        Node *ans = ob.divide(N, head);
        printList(ans); 
    }
    return 0;
}
  // } Driver Code Ends