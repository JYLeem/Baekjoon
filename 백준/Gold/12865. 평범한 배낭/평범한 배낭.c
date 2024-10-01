#include <stdio.h>

#define MAX_N 101
#define MAX_K 100001

int dp[MAX_N][MAX_K]; 

int main() {
    int N, K;
    int weight[MAX_N], value[MAX_N];
    
    scanf("%d %d", &N, &K);
    for (int i = 1; i <= N; i++) {
        scanf("%d %d", &weight[i], &value[i]);
    }
    
    for (int i = 1; i <= N; i++) {
        for (int w = 0; w <= K; w++) {
            dp[i][w] = dp[i-1][w];
            
            if (w >= weight[i]) {
                dp[i][w] = dp[i-1][w] > dp[i-1][w - weight[i]] + value[i] 
                    ? dp[i][w] 
                    : dp[i-1][w - weight[i]] + value[i];
            }
        }
    }
    
    printf("%d\n", dp[N][K]);

    return 0;
}
