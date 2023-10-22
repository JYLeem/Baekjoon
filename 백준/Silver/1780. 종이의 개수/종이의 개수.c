#include <stdio.h>
/*
    <나의 로직>
    board 랑 result 를 전역변수로 선언한다.
    1. checker
        3개 인자 입력 받음 (좌표, 좌표, N)
        2중 for 문을 통해 하나 씩 검사
            만약 같으면 return 1;
            다를 시 return 0;

    2. devide (재귀)
        3개 인자 입력 받음 (좌표, 좌표, N)
        만약 check에서 1을 리턴 받으면, 그 좌표에 있는 값의 리스트 +1
        만약 checker 에서 0을 받으면 /3 을 나눔

    3. main
        N * N 생성 후 모든 수에 +1 씩 해줌 (리스트에 집어 넣어야 하므로)
        값을 출력해줌
*/

int board[2187][2187];
int result[3] = {0,0,0};

int checker(int x, int y, int N){
    int tem = board[x][y];
    
    for (int i = x; i < x+N; i++){
        for (int j = y; j < y+N; j++){
            if (tem != board[i][j]) {return 0;}
        }
    }
    return 1;
}

void devide(int x, int y, int N){
    if (checker(x,y,N)){
        result[board[x][y]]++;
    } else {
        for (int i = x; i < x+N; i+= N/3){
            for (int j = y; j < y+N; j+= N/3){
                devide(i,j,N/3);
            }
        }
    }
}

int main(){
    int N;
    scanf("%d", &N);

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            scanf("%d", &board[i][j]);
            board[i][j]++;
        }
    }

    
    devide(0,0,N);

    for (int i = 0; i < 3; i++){
        printf("%d\n", *(result+i));
    }
    return 0;
}