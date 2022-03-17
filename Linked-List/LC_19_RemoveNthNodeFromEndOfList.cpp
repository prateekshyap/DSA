/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/
19. Remove Nth Node From End of List

https://practice.geeksforgeeks.org/problems/nth-node-from-end-of-linked-list/1/#

*/
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
//     ListNode* removeNthFromEnd(ListNode* head, int n) {
        
//         int len =0 ;
//         ListNode* ptr = head;
         
//         while(ptr!=nullptr)
//         {
//             len++;
//             ptr = ptr->next;
//         }
        
//         if(len < n) return nullptr;
        
//         ptr = head;
//         ListNode* prev = nullptr;
//         for(int i=1; i<len-n+1; i++)
//         {
//             prev = ptr;
//             ptr=ptr->next;
//         }
        
//         if(prev == nullptr)
//             head = head->next; // starting node
//         else
//             prev->next = ptr->next; // mid node
        
//         // delete(ptr);
//         // ptr = prev = nullptr;
        
//         return head;
        
//     }//end
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        
        ListNode* main_ptr = head;
        ListNode* ref_ptr = head;
        ListNode* prev = nullptr;
        
        if(!head) return nullptr;
        
        for(int i=1; i<n ; i++)
        {
            ref_ptr = ref_ptr->next;
            
        }
        
        while(ref_ptr!=nullptr && ref_ptr->next !=nullptr)
        {
            ref_ptr = ref_ptr->next;
            prev = main_ptr;
            main_ptr = main_ptr->next;
        }
        
        if(prev == nullptr)
            head = head->next; // starting node
        else
            prev->next = main_ptr->next; // mid node
        
        return head;
    }//end
};

// { Driver Code Starts
// C program to find n'th Node in linked list
#include <stdio.h>
#include <stdlib.h>
#include<iostream>
using namespace std;

/* Link list Node */
struct Node {
  int data;
  struct Node *next;
  Node(int x) {
    data = x;
    next = NULL;
  }
};


/* Function to get the nth node from the last of a linked list*/
int getNthFromLast(struct Node* head, int n);



/* Driver program to test above function*/
int main()
{
  int T,i,n,l,k;

    cin>>T;

    while(T--){
    struct Node *head = NULL,  *tail = NULL;

        cin>>n>>k;
        int firstdata;
        cin>>firstdata;
        head = new Node(firstdata);
        tail = head;
        for(i=1;i<n;i++)
        {
            cin>>l;
            tail->next = new Node(l);
            tail = tail->next;
        }

    cout<<getNthFromLast(head, k)<<endl;
    }
    return 0;
}// } Driver Code Ends


/* struct Node {
  int data;
  struct Node *next;
  Node(int x) {
    data = x;
    next = NULL;
  }
};
*/

//GFG

//Function to find the data of nth node from the end of a linked list.
int getNthFromLast(Node *head, int n)
{
       Node* main_ptr = head;
        Node* ref_ptr = head;
        Node* prev = nullptr;
        
        if(!head) return -1;
        
        for(int i=1; i<n ; i++)
        {
            ref_ptr = ref_ptr->next;
            if(!ref_ptr) return -1;
        }
         
        // int c=1;
        while(ref_ptr!=nullptr && ref_ptr->next !=nullptr)
        {
            ref_ptr = ref_ptr->next;
            prev = main_ptr;
            main_ptr = main_ptr->next;
            // c++;
        }
        
        // if(prev == nullptr)
        //     head = head->next; // starting node
        // else
        //     prev->next = main_ptr->next; // mid node
        
       
        
        return main_ptr->data;
}

