#include <stdio.h>

int main(void)
{
    int greedy[12] = {0};
	int n = 0;
	int k = 0;
	scanf("%d%d", &n, &k);
	for(int i = 0; i<n; i++) scanf("%d", &greedy[i]);
	
	int money = 0;
	int cnt = 0;
	
	while(1)
	{
		for(int i = 0; i<n; i++)
		{
			if(money+greedy[i] == k) {
				printf("%d", ++cnt);
				return 0;
			}
			if(money+greedy[i] > k) {
				money += greedy[i-1];
				cnt++;
				break;
			}
			if(i == n-1) {
				money += greedy[i];
				cnt++;
				break;
			}
		}
	}
}