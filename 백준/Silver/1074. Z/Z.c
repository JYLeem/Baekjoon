#include <stdio.h>
#include<math.h>

int count = 0;

void recur(int N, int r, int c){
    if (N == 1){
        return ;
    }
    else if ((r < N/2) && (c < N/2)){
        recur(N/2, r, c);
    }
    else if ((r < N/2) && (c >= N/2)){
        count += N*N/4;
        recur (N/2, r, c - N/2);
    }
    else if (r >= N/2 && c < N/2){
        count += (N*N/4) * 2;
        recur (N/2, r - N/2, c);
    }
    else {
        count += (N * N / 4) * 3;
        recur(N/2, r - N/2, c - N/2);
    }
}

int main(){
    int N, r, c;
    scanf("%d %d %d", &N, &r, &c);

    int size = pow(2,N);
    recur(size, r, c);

    printf("%d", count);


    return 0;
}