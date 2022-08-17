/*
https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1#
Given a linked list of 0s, 1s and 2s, sort it. 

*/

// { Driver Code Starts
#include <bits/stdc++.h>

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

struct Node *start = NULL;


 // } Driver Code Ends
/*
 
  Node is defined as
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
    //Function to sort a linked list of 0s, 1s and 2s.
    Node* segregate_(Node *head) {
        int zeroCnt=0;
        int oneCnt=0;
        int twoCnt=0;
        
        Node *ptr = head;
        while(ptr)
        {
            switch(ptr->data)
            {
                case 0:  zeroCnt++;
                    break;
                case 1: oneCnt++;
                    break;
                case 2: twoCnt++;
                    break;
            }
            ptr = ptr->next;
        }
        
        ptr = head;
        while(zeroCnt--)
        {
            ptr->data=0;
            ptr = ptr->next;
        }
        while(oneCnt--)
        {
            ptr->data=1;
            ptr = ptr->next;
        }
         while(twoCnt--)
        {
            ptr->data=2;
            ptr = ptr->next;
        }
        return head;
    }
    
    Node* segregate(Node *head) {
        Node *headZero = new Node(-1);
        Node *headOne = new Node(-2);
        Node *headTwo = new Node(-3);
        Node* p1 = headZero;
        Node* p2 = headOne;
        Node* p3 = headTwo;
        
        Node* ptr = head;
        while(ptr)
        {
            switch(ptr->data)
            {
                case 0:  p1->next = ptr;
                        p1=p1->next;
                    break;
                case 1: p2->next = ptr;
                        p2=p2->next;
                    break;
                case 2: p3->next = ptr;
                        p3=p3->next;
                    break;
            }
            ptr = ptr->next;
        }
        p3->next = nullptr;
        p2->next = headTwo->next;
        p1->next = headOne->next;
        
        return headZero->next;
    }
    
};


// { Driver Code Starts.

// Function to sort a linked list of 0s, 1s and 2s
void printList(struct Node *Node) {
    while (Node != NULL) {
        printf("%d ", Node->data);
        Node = Node->next;
    }
    printf("\n");
}

/* Drier program to test above function*/
void insert(int n1) {
    int n, value, i;
    // scanf("%d",&n);
    n = n1;
    struct Node *temp;
    for (i = 0; i < n; i++) {
        scanf("%d", &value);

        if (i == 0) {
            start = new Node(value);
            temp = start;
            continue;
        } else {
            temp->next = new Node(value);
            temp = temp->next;
            temp->next = NULL;
        }
    }
}

int main() {

    int n;

    int t;
    scanf("%d", &t);

    while (t--) {
        scanf("%d", &n);

        insert(n);
        Solution ob;
        struct Node *newHead = ob.segregate(start);
        printList(newHead);
    }

    return 0;
}  // } Driver Code Ends