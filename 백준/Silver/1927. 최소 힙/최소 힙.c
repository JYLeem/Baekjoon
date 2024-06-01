#include <stdio.h>
#include <stdlib.h>
/* 시간 초과!
    int delete = 0;

    int static compare(const void* first, const void* second){
        return *(int *)first - *(int *)second;
    }

    void pop(int *list, int listSize){
        qsort(list, listSize, sizeof(int), compare);
        if (*list != __INT_MAX__) printf("%d\n", *list);
        else printf("%d\n", 0);
        *list = __INT_MAX__;
    }

    int main(){
        int N; 
        scanf("%d", &N);
        int Q[N];
        
        for (int i = 0; i < N; i++){
            Q[i] = __INT_MAX__;
        }

        for (int i = 0; i < N; i++){
            int temp;
            scanf("%d", &temp);
            if (temp == 0){
                pop(Q, N);
            } else {
                Q[i] = temp;
            }
        }
        return 0;
    }
*/

int Heap[100001] = {}, size = 0, n;

void push(){
	int	cur = ++size;
    
	while (cur != 1 && Heap[cur / 2] > n) {
		Heap[cur] = Heap[cur / 2];
		cur /= 2;
	}
	Heap[cur] = n;
}

int	pop(){
	int	child, parent, root, temp;

	if (size == 0) return (0);
	child = 2;
	parent = 1;
	root = Heap[1];
	temp = Heap[size--];
	while (child <= size){
		if (child < size && Heap[child] > Heap[child + 1])
			child++;
		if (temp < Heap[child])
			break ;
		Heap[parent] = Heap[child];
		parent = child;
		child *= 2;
	}
	Heap[parent] = temp;
	return (root);
}

int main()
{
	int t;
	scanf("%d", &t);
	for (int i = 0; i < t; i++)
	{
		scanf("%d", &n);
		if (n == 0)
			printf("%d\n", pop());
		else
			push();
	}
	return (0);
}