import sys

sys.setrecursionlimit(10 ** 6)

N = int(input())

tree = [[] for _ in range(N + 1)]
parent = [None for _ in range(N + 1)]


def DFS(graph, vertex, visited):
    for i in graph[vertex]:
        if not visited[i]:
            visited[i] = vertex
            DFS(graph, i, visited)


for _ in range(N - 1):
    node_a, node_b = map(int, input().split())
    tree[node_a].append(node_b)
    tree[node_b].append(node_a)

DFS(tree, 1, parent)

for i in range(2, N + 1):
    print(parent[i])
