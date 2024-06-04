#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* 시간초과!

O(N^2) = 100,000 * 100,000 = 10,000,000,000 = 10초

int main(){
    int N, M;
    scanf("%d %d", &N, &M);
    char temp[100001];
    int arr[N];
    getchar();
    fgets(temp, sizeof(temp), stdin);
    int ansArr[M];
    int t = 0;

    int i = 0;
    char *token = strtok(temp, " ");
    while (token != NULL && i < N) {
        arr[i] = atoi(token);
        i++;
        token = strtok(NULL, " ");
    }

    for (int j = 0; j < M; j++){
        int x,y, ans = 0;
        scanf("%d %d", &x, &y);
        for (int k = x-1; k < y; k++){
            ans += arr[k];
        }
        ansArr[t] = ans;
        t++;
    }
    for (int i = 0; i < M; i++){
        printf("%d\n", ansArr[i]);
    }

    return 0;
}
*/ 

int main(){
    int N, M;
    scanf("%d %d", &N, &M);
    int *arr = (int *)malloc(sizeof(int) * (N+1));
    int *prefix = (int *)malloc(sizeof(int) * (N+1));

    for(int i = 1; i <= N; i++){
        scanf("%d", &arr[i]);
        prefix[i] = prefix[i-1] + arr[i];
    }

    for (int j = 0; j < M; j++){
        int x, y, ans = 0;
        scanf("%d %d", &x, &y);
        ans = prefix[y] - prefix[x-1]; 
        printf("%d\n", ans);
    }


    return 0;
}