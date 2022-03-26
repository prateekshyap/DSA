/*
https://leetcode.com/problems/rotate-list/
61. Rotate List

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
    ListNode* rotateRight(ListNode* head, int k) {
        
        if(!head || !head->next || k==0) return head;
        
        // count the number of nodes first
        int n=1;
        ListNode* ptr = head;
        while(ptr->next){
            n++;
            ptr = ptr->next;
        }
        
        k = k % n; // since k can be greater than n
        k = n - k ; // making it to equivalent left shift
        
        if(n==k) return head;
        
        ptr->next = head; //ptr is pointing to last node and we made last node point to head as we are rotating
        
        
        while(k--)
            ptr = ptr->next;
        
        head = ptr->next; // ptr now pointing to k-1 node from old head
        ptr->next = nullptr;
        
        return head;
    }// end
};