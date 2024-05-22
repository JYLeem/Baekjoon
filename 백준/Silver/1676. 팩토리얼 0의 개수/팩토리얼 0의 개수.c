#include <stdio.h>

/*
    전략: 2*5 의 갯수를 찾으면 해결 가능하지 않을까?
    count 변수 선언 -> 2,5 를 발견할 시 +1 
    n이 500까지 나오기 때문에 절때 팩토리얼로 풀어선 안된다. 
*/


int main(){
    int N;
    int num5 = 0;
    int num25 = 0;
    int num125 = 0;

    scanf("%d", &N);

    num5 = N / 5;
    num25 = N / 25;
    num125 = N / 125;

    printf("%d", num5 + num25 + num125);

    return 0;
}

/*
    출처: https://beginnerdeveloper-lit.tistory.com/18
    생각해 보니, 2의 배수가 5의 배수 보다 훨씬 많으므로, 5의 배수만 신경쓰면 된다. 
    또한, 25, 125는 5의 2,3개 있는 것이므로 중복으로 더 해주고, 625 까지의 수는 필요가 없다. (N = 500까지 이므로)
*/