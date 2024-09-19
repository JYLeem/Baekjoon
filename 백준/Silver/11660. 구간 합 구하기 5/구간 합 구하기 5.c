/*
#include <stdio.h>

struct Point {
    int x1;
    int x2;
    int y1;
    int y2;
};

int main(){
    int N, M;
    scanf("%d %d", &N, &M);

    int arr[N][N];

    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
            scanf("%d", &arr[i][j]);
        }
    }

    for (int i = 0; i < M; i++){
        struct Point point;
        int ans = 0;
        scanf("%d %d %d %d", &point.x1, &point.y1, &point.x2, &point.y2);

        for (int i = point.x1 - 1; i < point.x2; i++){
            for (int j = point.y1 - 1; j < point.y2; j++){
                ans += arr[i][j];
            }
        }

        printf("%d\n", ans);
    }

    return 0;
}
*/

#include <stdio.h>

struct Point {
    int x1;
    int x2;
    int y1;
    int y2;
};

int main() {
    int N, M;
    scanf("%d %d", &N, &M);

    int arr[N][N];
    int prefixSum[N + 1][N + 1]; 

    for (int i = 0; i <= N; i++) {
        for (int j = 0; j <= N; j++) {
            prefixSum[i][j] = 0;
        }
    }

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            scanf("%d", &arr[i - 1][j - 1]);

            prefixSum[i][j] = arr[i - 1][j - 1]
                + prefixSum[i - 1][j]   
                + prefixSum[i][j - 1]   
                - prefixSum[i - 1][j - 1]; 
        }
    }

    for (int k = 0; k < M; k++) {
        struct Point point;
        int ans = 0;
        scanf("%d %d %d %d", &point.x1, &point.y1, &point.x2, &point.y2);

        ans = prefixSum[point.x2][point.y2]
            - prefixSum[point.x1 - 1][point.y2]
            - prefixSum[point.x2][point.y1 - 1]
            + prefixSum[point.x1 - 1][point.y1 - 1];

        printf("%d\n", ans);
    }

    return 0;
}
