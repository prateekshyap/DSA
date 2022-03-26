/* 
 *	https://leetcode.com/problems/odd-even-linked-list/
 *  328. Odd Even Linked List
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
    
    ListNode* oddEvenList(ListNode* head) {
        
        if(!head || !head->next) return head;
        
        ListNode* even_head = head->next; // to concat to list
        
        ListNode* op = head;
        ListNode* ep = head->next;
        
        while(ep && ep->next)
        {
            op->next = ep->next;
            op = op->next;
            ep->next = op->next;
            ep = ep->next;
        }
        
        op->next = even_head;
        return head;
    }// end oddEvenList
    
//     ListNode* oddEvenList(ListNode* head) {
        
//         if(!head || !head->next) return head;
        
//         ListNode* odd_head = head; // odd list head
//         ListNode* even_head = head->next; // even list head
        
//         ListNode* op = head; // odd pointer list
//         ListNode* ep = head->next; // even pointer list
        
//         ListNode* ptr = head->next->next;
        
//         while(ptr)
//         {
            
//             op->next = ptr;
//             op = op->next;
            
//             ptr = ptr->next;
            
//             ep->next = ptr;
//             ep  = ep->next;
            
//             if(ptr)
//             ptr = ptr->next;
//         }
        
//         op->next = even_head;
        
//         return head;
//     }// end oddEvenList
};