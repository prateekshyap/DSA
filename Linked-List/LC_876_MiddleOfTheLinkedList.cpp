/*
https://leetcode.com/problems/middle-of-the-linked-list/
Middle of the linked-list

https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1/

https://binarysearch.com/problems/Central-Linked-List
*/

//LEETCODE

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
    ListNode* middleNode(ListNode* head) {
        
        ListNode* slow = head; // slow pointer, 1 step jump 
        ListNode* fast = head;  //fast pointer, 2 step jump
        
        if(head == nullptr) return nullptr;
        
        while(fast != nullptr && fast->next != nullptr)
        {
            
            slow = slow->next;
            fast = fast->next->next;
        }
        
        return slow;
    }//end
};

//GFG

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
/* Link list Node 
struct Node {
    int data;
    Node* next;
    
    Node(int x){
        data = x;
        next = NULL;
    }
    
}; */
class Solution{
    public:
    /* Should return data of middle node. If linked list is empty, then  -1*/
    int getMiddle(Node *head)
    {
       // Your Code Here
        Node* slow = head; // slow pointer, 1 step jump
        Node* fast = head; // fast pointer, 2 step jump
        Node* prev = nullptr;
        
        if(head == nullptr) return -1;
        
        while(fast != nullptr && fast->next != nullptr)
        {
            prev = slow;
            slow = slow->next;
            fast = fast->next->next;
            
        }
        
        return slow->data;
    }//end
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
        cout << ob.getMiddle(head) << endl;
    }
    return 0;
}
  // } Driver Code Ends