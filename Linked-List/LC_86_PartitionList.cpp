/*
https://leetcode.com/problems/partition-list/
86. Partition List

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
    ListNode* partition(ListNode* head, int x) {
        
        ListNode beforeHead = ListNode();
        ListNode afterHead = ListNode();
        ListNode *bef = &beforeHead;
        ListNode *aft = &afterHead;
        
        ListNode *ptr = head;
        
        while(head)
        {
            if(head->val < x)
            {
                bef->next = head;
                bef = bef->next;
            }
            else{
                aft->next = head;
                aft = aft->next;
            }
            
            head = head->next;
        }
        
        aft->next = nullptr;
        bef->next = afterHead.next;
        
        return beforeHead.next;
    }//END
};