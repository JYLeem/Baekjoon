#include<stdio.h>

// DFS 를 사용하자 

int N, M;
int mat[1001][1001] = {0,}, visit[1001];

void DFS(int start){
    visit[start] = 1;

    for(int i = 0; i < N; i++){
        if(mat[start][i] && !visit[i]) DFS(i);
    }
}

int main(){
    int ans = 0;
    scanf("%d %d", &N, &M);

    for(int i = 0; i < M; i++){
        int a, b;
        scanf("%d %d", &a, &b);
        mat[a-1][b-1] = 1;
        mat[b-1][a-1] = 1;
    }

    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            if (mat[i][j] && !visit[j]){
                DFS(j);
                ans++;
            }
        }
    }

    for(int i = 0; i < N; i++){
        if(!visit[i]) ans++;
    }

    printf("%d", ans);

    return 0;
}