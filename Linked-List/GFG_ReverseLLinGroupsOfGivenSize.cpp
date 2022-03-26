/* 
 *	https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
 *  Reverse a Linked List in groups of given size
 */
 
// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


struct node
{
    int data;
    struct node* next;
    
    node(int x){
        data = x;
        next = NULL;
    }
    
};

/* Function to print linked list */
void printList(struct node *node)
{
    while (node != NULL)
    {
        printf("%d ", node->data);
        node = node->next;
    }
    printf("\n");
}


 // } Driver Code Ends
/*
  Reverse a linked list
  The input list will have at least one element  
  Return the node which points to the head of the new LinkedList
  Node is defined as 
    struct node
    {
        int data;
        struct node* next;
    
        node(int x){
            data = x;
            next = NULL;
        }
    
    }*head;
*/

class Solution
{
    public:
    struct node *reverse (struct node *head, int k)
    { 
        // Complete this method
        
        if(!head || !head->next) return head;
        
        // return reverseLLRecursive(head, k);
        return reverseLLIterative(head, k);
        
    }//end reverse
    
    struct node* reverseLLIterative(struct node *head, int k)
    {
        if(!head || !head->next) return head;
        
        struct node* dummyHead = new struct node(0);
        dummyHead->next = head;
        
        struct node* prevGpHead = dummyHead;
        struct node* nxtGpHead = head;
        
        while(nxtGpHead)
        {
            struct node* prev = prevGpHead;
            struct node* curr = nxtGpHead;
            struct node* cnext = nullptr;
            struct node* currGpOldHead = nxtGpHead;
            
            // we don't need to check whether group of k exists or not
            // reverse the group of k nodes
            int countk=1;
            while(curr && countk<=k)
            {
                cnext = curr->next;
                curr->next = prev;
                prev = curr;
                curr = cnext;
                countk++;
            }
            nxtGpHead = curr;
            
            prevGpHead->next = prev; // previous group head point to current group head
            currGpOldHead->next = nxtGpHead;
            prevGpHead = currGpOldHead;
            
        }// end nxtGpHead
        
        head = dummyHead->next;
        delete(dummyHead);
        return head;
    }// end reverseLLIterative
    
    struct node* reverseLLRecursive(struct node *head, int k)
    {
        if(!head || !head->next) return head;
        
        struct node* ptr = head;
        
        struct node* prev = nullptr;
        struct node* curr = head;
        struct node* cnext = nullptr;
        int countk=1;
        
        while(curr && countk<=k)
        {
            cnext = curr->next;
            curr->next = prev;
            prev = curr;
            curr = cnext;
            countk++;
        }
        
        // if(cnext)
        head->next = reverseLLRecursive(cnext, k); // send next group
        
        return prev;
    }// end reverseLLRecursive
};


// { Driver Code Starts.

/* Drier program to test above function*/
int main(void)
{
    int t;
    cin>>t;
     
    while(t--)
    {
        struct node* head = NULL;
        struct node* temp = NULL;
        int n;
        cin >> n;
         
        for(int i=0 ; i<n ; i++)
        {
            int value;
            cin >> value;
            if(i == 0)
            {
                head = new node(value);
                temp = head;
            }
            else
            {
                temp->next = new node(value);
                temp = temp->next;
            }
        }
        
        int k;
        cin>>k;
        
        Solution ob;
        head = ob.reverse(head, k);
        printList(head);
    }
     
    return(0);
}

  // } Driver Code Ends