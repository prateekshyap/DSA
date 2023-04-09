# https://leetcode.com/problems/largest-color-value-in-a-directed-graph/

class Solution:
    def largestPathValue(self, colors: str, edges: List[List[int]]) -> int:
        graph = {}
        N = len(colors)
        for edge in edges:
            if edge[0] not in graph:
                graph[edge[0]] = list()
            graph[edge[0]].append(edge[1])
        count = [[0 for i in range(26)] for j in range(N)]
        visited = set()
        in_stack = set()
        result = 0
        for i in range(N):
            result = max(result,self.dfs(i, colors, graph, count, visited, in_stack))
        if result == sys.maxsize:
            return -1
        return result
    def dfs(self, node, colors, graph, count, visited, in_stack):
        if node in in_stack:
            return sys.maxsize
        if node in visited:
            return count[node][ord(colors[node])-98]
        visited.add(node)
        in_stack.add(node)
        if node in graph:
            for neigh in graph[node]:
                if self.dfs(neigh, colors, graph, count, visited, in_stack) == sys.maxsize:
                    return sys.maxsize
                for i in range(26):
                    count[node][i] = max(count[node][i],count[neigh][i])
        count[node][ord(colors[node])-98] = count[node][ord(colors[node])-98]+1
        in_stack.remove(node)
        return count[node][ord(colors[node])-98]