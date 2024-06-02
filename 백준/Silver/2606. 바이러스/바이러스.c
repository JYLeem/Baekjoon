#include <stdio.h>
#define true 1;
#define false 0;

/*
    그래프 탐색이다 -> DFS로 해결하면 될 것 같다.
    Adjacency Matrix [O(N^2)] vs Adjacency List [O(N+E)] -> N이 100개 이하이기 때문에 Matrix 로 가도 상관 없다. 
    O(N^2) -> 100 * 100 = 0.0001초 
    [1억번 -> 1초]
*/

int matrix[101][101];
int visited[101];
int ans = 0;

void dfs(int comNum, int move){
    for (int i = 0; i < comNum; i++){
        if (matrix[i][move] == 1 && visited[i] == 0){
            visited[i]  = true;
            dfs(comNum, i);
            ans++;
        }
    }
}


int main(){
    int com, net;
    int x, y;

    scanf("%d", &com);
    scanf("%d", &net);

    for(int i = 0; i < net; i++){
        scanf("%d %d", &x, &y);
        matrix[x-1][y-1] = true;
        matrix[y-1][x-1] = true;
    }
    visited[0] = true;
    
    dfs(com, 0);
    printf("%d", ans);

    return 0;
}