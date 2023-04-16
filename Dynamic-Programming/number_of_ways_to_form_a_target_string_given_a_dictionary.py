# https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/

class Solution:
    def numWays(self, words: List[str], target: str) -> int:
        n = len(target)
        k = len(words[0])
        freqs = [[0 for i in range(k)] for j in range(26)]
        table = [[-1 for i in range(k+1)] for j in range(n+1)]
        for s in words:
            for j in range(k):
                freqs[ord(s[j])-97][j] += 1
        return self.recur(target, freqs, n, k, table)
    def recur(self, target, freqs, i, j, table):
        if j == 0:
            if i == 0:
                return 1
            else:
                return 0
        if table[i][j] != -1:
            return table[i][j]
        table[i][j] = self.recur(target, freqs, i, j-1, table)
        if i > 0:
            table[i][j] += freqs[ord(target[i-1])-97][j-1]*self.recur(target,freqs,i-1,j-1,table)
            table[i][j] %= 1000000007
        return table[i][j]