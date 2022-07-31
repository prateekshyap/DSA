/*
https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1#
Clone a linked list with next and random pointer 
*/

// { Driver Code Starts
#include <bits/stdc++.h>

using namespace std;
/* Link list Node */
struct Node {
    int data;
    Node *next;
    Node *arb;

    Node(int x) {
        data = x;
        next = NULL;
        arb = NULL;
    }
};



 // } Driver Code Ends
class Solution
{
    
    unordered_map<Node* , Node*> clone;
    public:
    Node *copyList(Node *head)
    {
        /*  Hashmap with Recursion      */
        // return cloneMapFuncRec(head);
        /*  Hashmap without recursion   */
        // return cloneMapFuncNonRec(head);
        
        /* Without HashMap */
        //step 1: make a clone LL and insert between original LL
        Node* ptr = head;
        Node* newptr = nullptr;
        while(ptr)
        {
            newptr = new Node(ptr->data);
            newptr->next = ptr->next;
            ptr->next = newptr; // insert between nodes
            
            ptr = ptr->next->next; // double jump
        }
        
        //step 2: copy random pointer
        ptr = head;
        while(ptr)
        {
            if(ptr->next && ptr->arb)
                ptr->next->arb = ptr->arb->next;
            
            ptr  = ptr->next->next;
        }
        //step 3: delete original
        Node* clHead = head->next;
        Node* clptr = clHead;
        ptr = head;
        
        while(ptr && clptr)
        {
            ptr->next = ptr->next->next;
            ptr = ptr->next;
            
            clptr->next = clptr->next? clptr->next->next: clptr->next;
            clptr = clptr->next;
        }
        
        return clHead;
        
    }//end
    
    Node* cloneMapFuncNonRec(Node* head)
    {
        Node* ptr = head;
        Node* prev = nullptr;
        Node* newptr = nullptr;
        Node* clHead = nullptr;
        
        while(ptr)
        {
            newptr = new Node(ptr->data);
            clone[ptr] = newptr;
            ptr = ptr->next;
            if(prev)
            {
                prev->next = newptr;
                prev = prev->next;
            }else{
                prev = newptr;
                clHead = newptr;
            }
        }
        
        ptr = head;
        Node* clptr = clHead;
        while(clptr)
        {
            clptr->arb = clone[ptr->arb];
            ptr = ptr->next;
            clptr = clptr->next;
        }
        
        return clHead;
    }
    
    Node* cloneMapFuncRec(Node* head)
    {
        if(!head)
            return head;
        
        Node* cloned = new Node(head->data);
        clone[head] = cloned;
        cloned->next = cloneMapFuncRec(head->next);
        
        
        if(head->arb)
            cloned->arb = clone[head->arb];
        
        return cloned;
    }

};

// { Driver Code Starts.


void print(Node *root) {
    Node *temp = root;
    while (temp != NULL) {
        int k;
        if (temp->arb == NULL)
            k = -1;
        else
            k = temp->arb->data;
        cout << temp->data << " " << k << " ";
        temp = temp->next;
    }
}


void append(Node **head_ref, Node **tail_ref, int new_data) {

    Node *new_node = new Node(new_data);
    if (*head_ref == NULL) {
        *head_ref = new_node;
    } else
        (*tail_ref)->next = new_node;
    *tail_ref = new_node;
}

bool validation(Node *head, Node *res) {


    Node *temp1 = head;
    Node *temp2 = res;

    int len1 = 0, len2 = 0;
    while (temp1 != NULL) {
        len1++;
        temp1 = temp1->next;
    }
    while (temp2 != NULL) {
        len2++;
        temp2 = temp2->next;
    }

    /*if lengths not equal */

    if (len1 != len2) return false;

    temp1 = head;
    temp2 = res;
    map<Node*,Node*> a;
    while (temp1 != NULL) {
        
        if(temp1==temp2)
            return false;
        
        if (temp1->data != temp2->data) return false;
        if (temp1->arb != NULL and temp2->arb != NULL) {
            if (temp1->arb->data != temp2->arb->data)
                return false;
        } else if (temp1->arb != NULL and temp2->arb == NULL)
            return false;
          else if (temp1->arb == NULL and temp2->arb != NULL)
            return false;
        a[temp1]=temp2;
        temp1 = temp1->next;
        temp2 = temp2->next;
    }
    

    temp1 = head;
    temp2 = res;
    while (temp1 != NULL) {
        
        if (temp1->arb != NULL and temp2->arb != NULL) {
            if (a[temp1->arb] != temp2->arb) return false;
        }
        temp1 = temp1->next;
        temp2 = temp2->next;
    }
    return true;
}



int main() {

    int T, i, n, l, k;
    Node *generated_addr = NULL;
     /*reading input stuff*/
    cin >> T;
    while (T--) {
        generated_addr = NULL;
        struct Node *head = NULL, *tail = NULL;
        struct Node *head2 = NULL, *tail2 = NULL;
        cin >> n >> k;
        for (i = 1; i <= n; i++) {
            cin >> l;
            append(&head, &tail, l);
            append(&head2, &tail2, l);
        }
         for (int i = 0; i < k; i++) {
            int a, b;
            cin >> a >> b;

            Node *tempA = head;
            Node *temp2A = head2;
            int count = -1;

            while (tempA != NULL) {
                count++;
                if (count == a - 1) break;
                tempA = tempA->next;
                temp2A = temp2A->next;
            }
            Node *tempB = head;
            Node *temp2B = head2;
            count = -1;

            while (tempB != NULL) {
                count++;
                if (count == b - 1) break;
                tempB = tempB->next;
                temp2B = temp2B->next;
            }

            // when both a is greater than N
            if (a <= n){
                tempA->arb = tempB;
                temp2A->arb = temp2B;
            }
        }
        /*read finished*/

        generated_addr = head;
        Solution ob;
        struct Node *res = ob.copyList(head);
        if(validation(head2,res)&&validation(head,res))
            cout << validation(head2, res) << endl;
        else
            cout << 0 << endl;
    }
    return 0;
}  // } Driver Code Ends