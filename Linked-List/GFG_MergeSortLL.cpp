/*
https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1
Merge Sort for Linked List 
*/

// { Driver Code Starts
#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    struct Node* next;
    Node(int x) {
        data = x;
        next = NULL;
    }
};


 // } Driver Code Ends
/* Structure of the linked list node is as
struct Node 
{
    int data;
    struct Node* next;
    Node(int x) { data = x;  next = NULL; }
};
*/


class Solution{
  public:
    //Function to sort the given linked list using Merge Sort.
    Node* mergeSort(Node* head) {
        if(!head || !head->next)
            return head;
        
        Node* mid = findMiddle(head);
        Node* right = mid->next;
        Node* left = head;
        mid->next = nullptr;
        
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }
    
    Node* findMiddle(Node* head)
    {
        Node* slow = head;
        Node* fast = head->next;
        while(fast && fast->next){
            slow = slow->next;
            fast = fast->next->next;
        }
        
        return slow;
    }
    
    Node* merge(Node* l1, Node *l2)
    {
        Node *dummyHead = new Node(0);
        Node *ptr = dummyHead;
        
        while(l1 && l2)
        {
            if(l1->data <= l2->data){
                ptr->next = l1;
                l1 = l1->next;
            }
            else{
                ptr->next = l2;
                l2 = l2->next;
            }
            
            ptr = ptr->next;
        }
        
        if(l1)
            ptr->next = l1;
        else
            ptr->next = l2;
        
        return dummyHead->next;
    }
};


// { Driver Code Starts.

void printList(Node* node) {
    while (node != NULL) {
        printf("%d ", node->data);
        node = node->next;
    }
    printf("\n");
}

void push(struct Node** head_ref, int new_data) {
    Node* new_node = new Node(new_data);

    new_node->next = (*head_ref);
    (*head_ref) = new_node;
}

int main() {
    long test;
    cin >> test;
    while (test--) {
        struct Node* a = NULL;
        long n, tmp;
        cin >> n;
        for (int i = 0; i < n; i++) {
            cin >> tmp;
            push(&a, tmp);
        }
        Solution obj;
        a = obj.mergeSort(a);
        printList(a);
    }
    return 0;
}  // } Driver Code Ends