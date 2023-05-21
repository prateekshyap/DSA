# https://leetcode.com/problems/validate-stack-sequences/submissions/

class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        stack = list()
        pop_index = 0;
        for i in range(len(pushed)):
            stack.append(pushed[i])
            while (pop_index < len(popped) and len(stack) > 0 and popped[pop_index] == stack[len(stack)-1]):
                stack.pop()
                pop_index += 1
        return len(stack) == 0