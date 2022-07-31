/*
https://practice.geeksforgeeks.org/problems/given-a-linked-list-reverse-alternate-nodes-and-append-at-the-end/1#
Reverse alternate nodes in Link List 

*/

// { Driver Code Starts
#include<stdio.h>
#include<stdlib.h>
#include<iostream>
using namespace std;
/* A linked list node */


struct Node
{
    int data;
    struct Node *next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
    
};

struct Node *start = NULL;

/* Function to print nodes in a given linked list */
void printList(struct Node *node)
{
    while (node != NULL)
    {
        printf("%d ", node->data);
        node = node->next;
    }
    printf("\n");
    
}

void insert()
{
    int n,value;
    cin>>n;
    struct Node *temp;
    for(int i=0;i<n;i++)
    {
        cin>>value;
        if(i==0)
        {
            start = new Node(value);
            temp = start;
            continue;
        }
        else
        {
            temp->next = new Node(value);
            temp = temp->next;
        }
    }
}


 // } Driver Code Ends
/*
  reverse alternate nodes and append at the end
  The input list will have at least one element  
  Node is defined as 
  struct Node
  {
      int data;
      struct Node *next;
    
      Node(int x){
        data = x;
        next = NULL;
      }
    
   };

*/
class Solution
{
    public:
    void rearrange(struct Node *head)
    {
       int n=2;
       struct Node* cur = head->next;
       struct Node* oddHead = head;
       struct Node* odd = oddHead, *even = nullptr;
       struct Node* cnxt;
       
       //start frpm second node n=2
       while(cur)
       {
           if(n&1) //if odd node, make its list
           {
               odd->next = cur;
               odd = cur;
               cur = cur->next;
           }
           else //if even node
           {
               cnxt = cur->next; // as we are going to change cur->next value in order to insert in beginign
               if(!even) // if even node initialize first time
                {
                    even = cur;
                    even->next = nullptr;
                }
                else
                {
                   cur->next = even; //insertion in the begining //reversing
                   even = cur;
                }
               cur = cnxt; // next element in the list
           }
           n++;
       }
       odd->next = even;// merge both list
       head = oddHead;
       
    }
};



// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while (t--) {
        insert();
        Solution ob;
        ob.rearrange(start);
        printList(start);
    }
    return 0;
}
  // } Driver Code Ends