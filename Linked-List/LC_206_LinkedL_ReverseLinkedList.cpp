/* https://leetcode.com/problems/reverse-linked-list/
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
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

    ListNode* reverseList(ListNode* head) {

        //return reverseListIterative(head);
        //return reverseListRecurive(head);
        return reverseListRecurive2(head);

    }

    ListNode* reverseListIterative(ListNode* head) {
        ListNode *p = nullptr, *q=head, *r = nullptr;
        while(q){
            r = q->next;
            q->next = p;
            p=q;
            q=r;
        }
        return p;
    }

    ListNode* reverseListRecurive(ListNode* p) {
        if (!p || !(p->next)) {
            return p;
        }

        ListNode* t = reverseListRecurive(p->next);
        p->next->next = p;          // p->next node next link is not yet changed
        p->next = nullptr;
        return t;
    }

    ListNode* reverseListRecurive2(ListNode* curr, ListNode* prev = nullptr) {
        if (!curr) {
            return curr;
        }

        if (!curr->next) {
            curr->next = prev;
            return curr ;
        }
        ListNode* curr_next = curr->next;
        curr->next = prev;
        return reverseListRecurive2(curr_next, curr);
    }
};