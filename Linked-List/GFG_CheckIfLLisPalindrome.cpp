/*
https://practice.geeksforgeeks.org/problems/check-if-linked-list-is-pallindrome/1#
Check if Linked List is Palindrome 
*/

// { Driver Code Starts
#include <stdio.h>
#include <stdlib.h>
#include <iostream>
#include <stack>
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

class Solution{
  public:
    //Function to check whether the list is palindrome.
    bool isPalindrome(Node *head)
    {
        if(!head || !head->next) 
            return true;
        
        //finding mid element
        Node* mid = nullptr;
        Node* slow = head, *fast=head->next;
        while(fast && fast->next)
        {
            slow = slow->next;
            fast = fast->next->next;
        }
        mid = slow;
        Node *list2 = mid->next;
        // reversing the second list
        Node *prev = nullptr, *cur=list2, *cnxt = nullptr;
        while(cur)
        {
            cnxt = cur->next;
            cur->next = prev;
            prev = cur;
            cur = cnxt;
        }
        
         list2 = prev;
         mid->next = nullptr; // 1 -> * || 2 || <-1,   1->2->* || *<-3<-4
        // checing the palindrome
        while(list2)
        {
            if(list2->data != head->data)
                return false;
            list2 = list2->next;
            head = head->next;
        }
        
        return true;
    }
};



// { Driver Code Starts.
/* Driver program to test above function*/
int main()
{
  int T,i,n,l,firstdata;
    cin>>T;
    while(T--)
    {
        
        struct Node *head = NULL,  *tail = NULL;
        cin>>n;
        // taking first data of LL
        cin>>firstdata;
        head = new Node(firstdata);
        tail = head;
        // taking remaining data of LL
        for(i=1;i<n;i++)
        {
            cin>>l;
            tail->next = new Node(l);
            tail = tail->next;
        }
    Solution obj;
   	cout<<obj.isPalindrome(head)<<endl;
    }
    return 0;
}

  // } Driver Code Ends