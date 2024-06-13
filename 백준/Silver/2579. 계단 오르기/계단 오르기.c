#include <stdio.h>

/*
    DP or Greedy Algorithm 을 사용해야 한다. 
    N = 300 이하의 자연수 이고, 시간 제한은 1초이다. 
    대표적인 DP 문제이다. 
*/

int max(int a, int b){
    return a > b ? a : b;
}

int main(){
    int N, ans;
    int arr[301], dp[301];
    scanf("%d", &N);

    for (int i = 0; i < N; i++){
        scanf("%d", &arr[i]);
    }

    dp[0] = arr[0];
    dp[1] = max(arr[0] + arr[1], arr[1]);
    dp[2] = max(arr[0] + arr[2], arr[1] + arr[2]);

    for (int j = 3; j < N; j++){
        dp[j] = max(dp[j-2] + arr[j], arr[j-1] + arr[j] + dp[j-3]);
    }

    printf("%d", dp[N-1]);


    return 0;
}
