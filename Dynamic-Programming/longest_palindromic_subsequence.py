# https://leetcode.com/problems/longest-palindromic-subsequence/

class Solution:
    def longestPalindromeSubseq(self, s: str) -> int:
        l = len(s)
        rev = s[::-1]
        dp = [[0 for i in range(l+1)] for j in range(l+1)]
        for i in range(1,l+1):
            for j in range(1,l+1):
                if s[i-1] != rev[j-1]:
                    dp[i][j] = max(dp[i-1][j],dp[i][j-1])
                else:
                    dp[i][j] = dp[i-1][j-1]+1
        return dp[l][l]