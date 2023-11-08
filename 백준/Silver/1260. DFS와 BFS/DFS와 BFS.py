from collections import deque

node_num, edge_num, start_node = map(int, input().split())
graph = [[] for _ in range(node_num + 1)]

for _ in range(edge_num):
    start, end = map(int, input().split())
    graph[start].append(end)
    graph[end].append(start)

for gra in graph:
    gra.sort()

dfs_visited = [False] * (node_num + 1)
bfs_visited = [False] * (node_num + 1)

def dfs(start_node):
    stack = [start_node]
    while stack:
        node = stack.pop()
        if not dfs_visited[node]:
            dfs_visited[node] = True
            print(node, end=' ')
            stack.extend(reversed([n for n in graph[node] if not dfs_visited[n]]))

def bfs(start_node):
    queue = deque([start_node])
    bfs_visited[start_node] = True
    while queue:
        node = queue.popleft()
        print(node, end=' ')
        for neighbor in graph[node]:
            if not bfs_visited[neighbor]:
                queue.append(neighbor)
                bfs_visited[neighbor] = True

dfs(start_node)
print()
bfs(start_node)
